package com.pluralsight.ui;

import com.pluralsight.model.Dealership;
import com.pluralsight.model.Vehicle;
import com.pluralsight.persistence.DealershipFileManager;

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
        String input;
        double min = -1;
        double max = -1;

        while (min < 0) {
            System.out.print("Enter The Minimum Price: ");
            input = scanner.nextLine();
            try {
                min = Double.parseDouble(input);
                if (min < 0) {
                    System.out.println("Minimum price must be non-negative. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        while (max <= 0) {
            System.out.print("Enter The Maximum Price: ");
            input = scanner.nextLine();
            try {
                max = Double.parseDouble(input);
                if (max <= 0 || max < min) {
                    System.out.println("Maximum price must be greater than the minimum price. Please try again.");
                    max = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }


    public void processGetByMakeModelRequest(){

    }
    public void processGetByYearRequest(){
        String input;
        int min = 1900;
        int max = 0;

        while (min <= 1900) {
            System.out.print("Enter The Minimum Year: ");
            input = scanner.nextLine();
            try {
                min = Integer.parseInt(input);
                if (min < 0) {
                    System.out.println("Minimum price must be non-negative. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        while (max <= 0) {
            System.out.print("Enter The Maximum Year: ");
            input = scanner.nextLine();
            try {
                max = Integer.parseInt(input);
                if (max <= 0 || max < min) {
                    System.out.println("Maximum price must be greater than the minimum price. Please try again.");
                    max = 0;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    public void processGetByColorRequest(){

    }

    public void processGetByMileageRequest(){

    }

    public void processGetByVehicleTypeRequest(){

    }

    public void processGetAllVehiclesRequest(){
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(){

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
}
