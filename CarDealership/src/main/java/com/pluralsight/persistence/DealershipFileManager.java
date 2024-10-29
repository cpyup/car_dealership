package com.pluralsight.persistence;

import com.pluralsight.model.Dealership;
import com.pluralsight.model.Vehicle;

import java.io.*;

/**
 * The {@code DealershipFileManager} class provides methods to manage
 * the persistence of {@code Dealership} and its associated {@code Vehicle}
 * data using a CSV file format.
 * <p>
 * This class supports loading a dealership from a CSV file and saving
 * the dealership back to the file.
 * </p>
 */
public class DealershipFileManager {
    private static final String FILE_PATH = "dealership.csv";

    /**
     * Retrieves a {@code Dealership} object by reading from the
     * predefined CSV file.
     *
     * @return the {@code Dealership} object populated with data from the
     *         file, or {@code null} if an error occurs during file
     *         reading.
     */
    public Dealership getDealership(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            Dealership dealership = null;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\|");

                // Collecting dealer information
                if(dealership == null && values.length == 3){
                    dealership = new Dealership(values[0].trim(),values[1].trim(),values[2].trim());
                }
                // Collecting inventory information
                if(dealership!=null && values.length == 8){
                    dealership.addVehicle(parseValues(values));
                }
            }
            return dealership;
        }catch(IOException e){
            System.out.println("Error Reading Data File");
            return null;
        }

    }

    /**
     * Saves the given {@code Dealership} object to the predefined
     * CSV file.
     *
     * @param dealership the {@code Dealership} object to be saved.
     */
    public void saveDealership(Dealership dealership){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))){
            writer.write(dealership.toString());
        }catch(IOException e){
            System.out.println("Error Writing Data File");
        }
    }

    /**
     * Parses an array of string values into a {@code Vehicle} object.
     *
     * @param values the array of string values representing vehicle details.
     * @return a {@code Vehicle} object created from the parsed values,
     *         or {@code null} if a parsing error occurs.
     */
    private Vehicle parseValues(String[] values){
        try{
            int vin = Integer.parseInt(values[0]);
            int year = Integer.parseInt(values[1]);
            String make = values[2].trim();
            String model = values[3].trim();
            String vehicleType = values[4].trim();
            String color = values[5].trim();
            int odometer = Integer.parseInt(values[6]);
            double price = Double.parseDouble(values[7]);

            return new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
        } catch (NumberFormatException e) {
            System.out.println("Error Parsing Data");
            return null;
        }
    }
}
