package com.pluralsight.persistence;

import com.pluralsight.model.Dealership;
import com.pluralsight.model.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    private static final String FILE_PATH = "dealership.csv";

    public Dealership getDealership(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))){
            Dealership dealership = null;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\|");
                if(dealership == null && values.length == 3){  // Dealer info
                    dealership = new Dealership(values[0].trim(),values[1].trim(),values[2].trim());
                }
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

    public void saveDealership(Dealership dealership){

    }

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
