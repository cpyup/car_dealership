package com.pluralsight.persistence;

import com.pluralsight.model.Dealership;
import com.pluralsight.model.Vehicle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class DealershipFileManager {
    public Dealership getDealership(){
        Dealership dealership = null;
        try(BufferedReader reader = new BufferedReader(new FileReader("dealership.csv"))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split("\\|");
                if(dealership == null && values.length == 3){  // Dealer info
                    dealership = new Dealership(values[0].trim(),values[1].trim(),values[2].trim());
                }else if(values.length == 8 && dealership != null){  // Inventory info
                    int vin = Integer.parseInt(values[0]);
                    int year = Integer.parseInt(values[1]);
                    String make = values[2].trim();
                    String model = values[3].trim();
                    String vehicleType = values[4].trim();
                    String color = values[5].trim();
                    int odometer = Integer.parseInt(values[6]);
                    double price = Double.parseDouble(values[7]);

                    Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price);
                    dealership.addVehicle(vehicle);
                }

            }
        }catch(IOException e){
            System.out.println("Error Reading Data File");
            return null;
        }

        return null;
    }

    public void saveDealership(Dealership dealership){

    }
}
