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

    public List<Vehicle> getVehiclesByPrice(Double min, Double max){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if((min == null || vehicle.getPrice() >= min) && (max == null || vehicle.getPrice() <= max)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if((vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)) ||
                    (vehicle.getMake().equalsIgnoreCase(make) && model.equals(""))){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(Integer min, Integer max){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if((max == null || vehicle.getYear() <= max) && (min == null || vehicle.getYear() >= min)){
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

    public List<Vehicle> getVehiclesByMileage(Integer min, Integer max){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if((max == null || vehicle.getOdometer() <= max) && (min == null || vehicle.getOdometer() >= min)){
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
