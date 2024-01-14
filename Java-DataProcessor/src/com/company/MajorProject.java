package com.company;

import org.firmata4j.I2CDevice;
import org.firmata4j.Pin;
import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.ssd1306.SSD1306;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class MajorProject {
    public static void main(String[] args)
            throws InterruptedException, IOException {
        var myArduino = new FirmataDevice("COM4");
        myArduino.start();
        myArduino.ensureInitializationIsDone();

        final String fileName = "CoolTerm Capture 2022-04-14 03-41-31.txt";
        var theAirQuality = new File(fileName);
        var fixedLengthList = Files.readAllLines(theAirQuality.toPath());
        ArrayList<String> listOfString = new ArrayList<>(fixedLengthList);

        double CO2 = 0;
        double TVOC = 0;
        int counter = 0;
        while (counter < listOfString.size()) {
            CO2 = Double.parseDouble(listOfString.get(counter).split(",")[0]) + CO2;
            TVOC = Double.parseDouble(listOfString.get(counter).split(",")[1]) + TVOC;
            counter++;
        }

        int CO2Avg = (int) (CO2 / (counter));
        int TVOCAvg = (int) (TVOC / (counter));
        System.out.println("Average of Carbon Dioxide of the room is: " + CO2Avg + "ppm");
        System.out.println("Average TVOC of the room is: " + TVOCAvg + "ppb");

        I2CDevice i2cObject = myArduino.getI2CDevice((byte) 0x3C);

        SSD1306 displayObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64);
        displayObject.init();

        Pin LED = myArduino.getPin(4);
        LED.setMode(Pin.Mode.OUTPUT);
        Pin Sound = myArduino.getPin(5);

        while (true) {

            if (CO2Avg > 700 || TVOCAvg > 65) {
                LED.setValue(1);
                Sound.setValue(1);
                Sound.setValue(0);
                displayObject.getCanvas().drawString(0, 0,   "CO2:" + CO2Avg + "ppm, " +"TVOC:" + TVOCAvg + "ppb" + "The air is polluted! please open the window" );
                displayObject.display();

            } else {
                LED.setValue(0);
                displayObject.getCanvas().drawString(0, 0,   "CO2:" + CO2Avg + "ppm, " +"TVOC:" + TVOCAvg + "ppb" );
                displayObject.display();
            }

        }

    }

}