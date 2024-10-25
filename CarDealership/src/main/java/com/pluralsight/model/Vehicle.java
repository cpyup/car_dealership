package com.pluralsight.model;

public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public int getVin() {
        return vin;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public int getOdometer() {
        return odometer;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("Vin: "+vin+"\n");
        output.append("Year: "+year+"\n");
        output.append("Make: "+make+"\n");
        output.append("Model: "+model+"\n");
        output.append("Type: "+vehicleType+"\n");
        output.append("Color: "+color+"\n");
        output.append("Odometer: "+odometer+"\n");
        output.append("Price: "+price+"\n");
        return output.toString();
    }
}
