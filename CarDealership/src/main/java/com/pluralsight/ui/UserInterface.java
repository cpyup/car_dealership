package com.pluralsight.ui;

import com.pluralsight.model.Dealership;
import com.pluralsight.model.Vehicle;
import com.pluralsight.persistence.DealershipFileManager;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private static final Scanner scanner = new Scanner(System.in);

    public void display(){
        init();
        String input;

        while(true){
            outputMenu();
            input = scanner.nextLine().trim();

            switch (input){
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileageRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetAllVehiclesRequest();
                case "8" -> processAddVehicleRequest();
                case "9" -> processRemoveVehicleRequest();
                case "99" -> {
                    return;
                }
                default -> System.out.println("Invalid Option");
            }
        }
    }

    public void processGetByPriceRequest() {
        Double min = getDoubleInput(0.0,"Minimum Price",true);
        Double max = getDoubleInput((min != null ? min : 0.0),"Maximum Price",true);
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    public void processGetByMakeModelRequest(){
        String make = getStringInput("Make",false);
        String model = getStringInput("Model",true);

        displayVehicles(dealership.getVehiclesByMakeModel(make,model));
    }

    public void processGetByYearRequest(){
        Integer min = getIntegerInput(1900, getMaxYear(),"Minimum Year",true);
        Integer max = getIntegerInput(min,getMaxYear(),"Maximum Year",true);

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByColorRequest(){
        displayVehicles(dealership.getVehiclesByColor(getStringInput("Color",false)));
    }

    public void processGetByMileageRequest(){
        Integer min = getIntegerInput(0,null, "Minimum Mileage",true);
        Integer max = getIntegerInput((min != null ? min : 0),null,"Maximum Mileage",true);

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    public void processGetByVehicleTypeRequest(){
        displayVehicles(dealership.getVehiclesByType(getStringInput("Type",false)));
    }

    public void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(){
        try{
            String make = getStringInput("Make",false);
            String model = getStringInput("Model",false);
            String type = getStringInput("Type",false);
            String color = getStringInput("Color",false);
            Integer vin = getIntegerInput(0,null,"Vin",false);
            Integer year = getIntegerInput(1900,getMaxYear(),"Year",false);
            Integer odometer = getIntegerInput(0,null,"Mileage",false);
            Double price = getDoubleInput(0.0,"Price",false);

            if(vin != null && year != null && odometer != null && price != null){
                Vehicle vehicle = new Vehicle(vin,year,make,model,type,color,odometer,price);
                dealership.addVehicle(vehicle);
                initiateSave();
            }else{
                throw new RuntimeException();
            }
        }catch (Exception e){
            System.out.println("Error processing input");
        }
    }

    public void processRemoveVehicleRequest(){

    }

    private void init(){
        DealershipFileManager manager = new DealershipFileManager();
        dealership = manager.getDealership();
    }

    private void outputMenu(){
        System.out.println("Dealership Menu Options:");
        System.out.println("\t1 - Search By Price");
        System.out.println("\t2 - Search By Make/Model");
        System.out.println("\t3 - Search By Year");
        System.out.println("\t4 - Search By Color");
        System.out.println("\t5 - Search By Mileage");
        System.out.println("\t6 - Search By Type");
        System.out.println("\t7 - List All Vehicles");
        System.out.println("\t8 - Add A Vehicle");
        System.out.println("\t9 - Remove A Vehicle");
        System.out.println("\t99 - Quit");
    }

    private void displayVehicles(List<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    private void initiateSave(){
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveDealership(dealership);
    }

    private int getMaxYear(){
        LocalDateTime now = LocalDateTime.now();
        return now.getYear() + 1;
    }

    private String getStringInput(String displayType, boolean isNullable){
        String input = "";

        while (input.isBlank()) {
            System.out.printf("Enter The Desired %s"+(isNullable ? " (or press enter to leave blank)":"")+": ",displayType);
            try {
                input = scanner.nextLine().trim();
                if(isNullable)return input;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid type.");
            }
        }
        return input;
    }

    private Integer getIntegerInput(Integer min, Integer max, String verbiage, boolean isNullable){
        String input;
        int targetInt = -1;
        while(targetInt < 0 || (min != null && targetInt < min) || (max != null && targetInt > max)){
            System.out.printf("Enter The %s"+(isNullable ? " (or press 'enter' to leave blank)" : "")+": ",verbiage);
            input = scanner.nextLine();
            if(isNullable&&input.isBlank())return null;
            try {
                targetInt = Integer.parseInt(input);
                if (targetInt < 0) System.out.println("Number must be non-negative. Please try again.");
                if(max != null && targetInt > max) System.out.printf("Number cannot be larger than %s. Please try again.%n",max);
                if(min != null && targetInt < min) System.out.printf("Number cannot be smaller than %s. Please try again.%n",min);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return targetInt;
    }

    private Double getDoubleInput(Double min, String verbiage, boolean isNullable){
        String input;
        double targetDouble = -1.0;
        while(targetDouble < 0 || (min != null && (targetDouble < min))){
            System.out.printf("Enter The %s"+(isNullable ? " (or press 'enter' to leave blank)" : "")+": ",verbiage);
            input = scanner.nextLine();
            if(isNullable&&input.isBlank())return null;
            try {
                targetDouble = Double.parseDouble(input);
                if (targetDouble < 0){
                    System.out.println("Number must be non-negative. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
        return targetDouble;
    }
}
