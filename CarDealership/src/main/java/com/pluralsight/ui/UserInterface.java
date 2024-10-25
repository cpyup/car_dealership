package com.pluralsight.ui;

import com.pluralsight.model.Dealership;
import com.pluralsight.model.Vehicle;
import com.pluralsight.persistence.DealershipFileManager;

import java.util.ArrayList;
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

    public void processGetByPriceRequest(){

    }

    public void processGetByMakeModelRequest(){

    }
    public void processGetByYearRequest(){

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
        System.out.println("temp menu");
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }
}
