package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private final String name;
    private final String address;
    private final String phone;
    private final List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(Double min, Double max){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if((min == null || vehicle.price() >= min) && (max == null || vehicle.price() <= max)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if((vehicle.make().equalsIgnoreCase(make) && vehicle.model().equalsIgnoreCase(model)) ||
                    (vehicle.make().equalsIgnoreCase(make) && model.equals(""))){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByYear(Integer min, Integer max){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if((max == null || vehicle.year() <= max) && (min == null || vehicle.year() >= min)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.color().equalsIgnoreCase(color)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByMileage(Integer min, Integer max){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if((max == null || vehicle.odometer() <= max) && (min == null || vehicle.odometer() >= min)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getVehiclesByType(String type){
        List<Vehicle> vehicles = new ArrayList<>();

        for(Vehicle vehicle : inventory){
            if(vehicle.vehicleType().equalsIgnoreCase(type)){
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public List<Vehicle> getVehiclesByVin(int vin){
        return inventory.stream().
                filter(vehicle -> vehicle.vin()==vin).toList();
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(String.format("%s|%s|%s",name,address,phone));
        for(Vehicle vehicle : inventory){
            output.append(String.format("%n%d|%d|%s|%s|%s|%s|%d|%.2f",
                    vehicle.vin(),vehicle.year(),vehicle.make(),vehicle.model(),vehicle.vehicleType(),
                    vehicle.color(),vehicle.odometer(),vehicle.price()));
        }
        return output.toString();
    }
}
