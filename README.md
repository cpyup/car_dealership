# Car Dealership Application

## Project Summary

This CLI application is designed to be used as an inventory management system for a dealership, allowing salesmen to easily search the current vehicle inventory based on desired customer criteria with minimal input.

Inventory is stored in an external file, allowing for widespread usage of the application across the industry. Vehicles can also be added or removed directly from the command line interface, streamlining the inventory management experience.

## User Stories

Collection of user stories that guided the development of my application:
>As a salesman, I want to search for vehicles within a specific price range so that I can quickly find options that meet my customers' budget.
>
>As a salesman, I want to filter vehicles by make and model so that I can present my customers with the exact cars they are interested in.
>
>As a dealership owner, I would like for the application to load my dealership's current inventory from a local file, so that I can maintain control over my business's data.
>
>As a salesman, I want to search for vehicles within a specific year range to help customers looking for newer or older models.
>
>As a salesman, I want to filter vehicles by color so that I can show customers options that match their personal preferences.
>
>As a salesman, I want to search for vehicles based on mileage range to ensure I present options that fit my customers' criteria for vehicle usage.
>
>As a salesman, I want to filter vehicles by type (like SUV, sedan, etc.) so that I can efficiently match customers with the vehicle type they desire.
>
>As a sales manager, I want to view a comprehensive list of all available vehicles so that I can quickly assess inventory and identify potential sales opportunities.
>
>As a dealership owner, I want to add new vehicles to the inventory so that I can ensure our listings are up-to-date and reflect all available options.
>
>As a dealership owner, I want to remove sold or outdated vehicles from the inventory so that I can keep our listings accurate and relevant for potential buyers.

## Setup Instructions

Instructions on how to set up and run the project using IntelliJ IDEA.

### Prerequisites

- IntelliJ IDEA: Ensure you have IntelliJ IDEA installed, which you can download from [here](https://www.jetbrains.com/idea/download/).
- Java SDK: Make sure Java SDK is installed and configured in IntelliJ.

### Running the Application in IntelliJ

Follow these steps to get your application running within IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Select "Open" and navigate to the directory where you cloned or downloaded the project.
3. After the project opens, wait for IntelliJ to index the files and set up the project.
4. Find the main class with the `public static void main(String[] args)` method.
5. Right-click on the file and select 'Run 'Program.main()'' to start the application.

## Technologies Used

- IntelliJ IDEA Community Edition 2022.3.2.0
- Java Version 17

## Display Examples

### Display All Vehicles

![All Vehicles](https://github.com/cpyup/car_dealership/blob/main/screenshots/display_all.png?raw=true)

### Add Vehicle To Inventory

![Adding Vehicle](https://github.com/cpyup/car_dealership/blob/main/screenshots/add_vehicle.png?raw=true)

### Error Handling

[TODO]

## Project Highlights

>My only real highlight for this one would be the way that I handled nullable inputs when getting data from the scanner. When searching for vehicles, most values can be left blank. In testing I found this to create a bit of a redundancy in display logic, as every method could display the full inventory if both values were blank. I decided to make it so that when searching for a range of values, only either the minimum OR maximum would be allowed a null input, not both.

### Min And Max As Nullable Option

![Both As Nullable](https://github.com/cpyup/car_dealership/blob/main/screenshots/min_max.png?raw=true)

### Min As Null (Max No Longer Nullable)

![Min As Null](https://github.com/cpyup/car_dealership/blob/main/screenshots/min_null_max.png?raw=true)

## Future Work

- Implement Sales and Leasing