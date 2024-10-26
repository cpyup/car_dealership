package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice() <= max && vehicle.getPrice() >= min){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice() <= max && vehicle.getPrice() >= min){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice() <= max && vehicle.getPrice() >= min){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String type){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(type)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(inventory.indexOf(vehicle));
    }
}
