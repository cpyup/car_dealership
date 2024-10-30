package com.pluralsight.model;

public record Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer,
                      double price) {

    @Override
    public String toString() {
        return String.format("%-6d %-5d %-10s %-10s %-10s %-10s %-8d $%-,12.2f",
                vin,year,make,model,vehicleType,color,odometer,price);
        /*return "Vin: " + vin + "\t\t" +
                "Year: " + year + "\t\t" +
                "Make: " + make + "\t\t\t\t" +
                "Model: " + model + "\t\t\t\t" +
                "Type: " + vehicleType + "\t\t" +
                "Color: " + color + "\t\t" +
                "Odometer: " + odometer + "\t\t\t\t" +
                "Price: " + price;*/
    }
}
