# Air Quality Monitoring System

## Overview

This repository contains the code and documentation for an Air Quality Monitoring System implemented using Arduino and Java. The project aims to monitor Total Volatile Organic Compounds (TVOC), particulate matter (PM2.5), and CO2 levels in indoor environments. The system utilizes an SGP30 Air Quality Sensor from the Grove Beginner Kit, Arduino for data capture, and Java for data processing and user interaction.

## Project Structure

- **Arduino-AirQualityCapturer:**
  - **Arduino.ino:** Arduino code to capture air quality data using the SGP30 sensor and send it to the computer.
  - **Arduino.txt:** Sample data capture exported from Arduino, containing TVOC and CO2 levels.

- **Java-DataProcessor:**
  - **AirQualityProcessor.java:** Java code to process the data received from Arduino, calculate average CO2 and TVOC levels, and provide warnings if levels exceed recommended thresholds.
  - **SampleData.txt:** Sample data file used for testing and processing by the Java program.

## How to Run

1. **Arduino Setup:**
   - Connect the SGP30 Air Quality Sensor to your Arduino as per the provided diagram (Figure 1).
   - Upload the `Arduino.ino` code to your Arduino-compatible device.

2. **Java Setup:**
   - Ensure you have Java and Arduino installed on your computer.
   - Open the `AirQualityProcessor.java` file in your preferred Java IDE.
   - Run the Java program, which will read data from the exported Arduino file (Arduino.txt) and process it.

## Results and Testing

- The system was tested by unplugging and re-plugging the SGP30 sensor to ensure proper data reception.
- Manual testing involved introducing additional CO2 into the sensor and verifying that the data values changed accordingly.
- The system was also tested with different threshold limits to trigger warnings for CO2 and TVOC levels.

## Learning Outcomes

- The project successfully met learning outcomes by testing and debugging the Java program and designing a solution for monitoring air quality.
- Ready-made collections were effectively used to process and aggregate data received from the sensor.
- The Arduino program demonstrated event-driven behavior, updating data per second.
- Object-oriented programming principles were applied to design the Java code.

## Video Explanation

For a detailed explanation of the project, refer to the [YouTube video](https://www.youtube.com/watch?v=0-NlmySoyLs&t=233s&ab_channel=AliHussaini).

## Contingency

The project initially aimed for direct data reception by the Java program without manual export, but a suitable library could not be identified. Future iterations may explore options for a direct connection.

## Additional Material

Given the global concerns related to COVID-19, this project serves as a contribution to monitoring air quality, potentially aiding in reducing the spread of airborne viruses in crowded areas.

## Conclusion and Recommendations

In conclusion, the implemented Air Quality Monitoring System effectively alerts users to elevated levels of CO2 and TVOC in their environment. The recommendation includes exploring options for direct data reception in the Java program for enhanced user convenience.

Feel free to explore the repository and contribute to the project's improvement!

