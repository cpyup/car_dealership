package com.pluralsight.model;

public record Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer,
                      double price) {

    @Override
    public String toString() {
        return "Vin: " + vin + "\n" +
                "Year: " + year + "\n" +
                "Make: " + make + "\n" +
                "Model: " + model + "\n" +
                "Type: " + vehicleType + "\n" +
                "Color: " + color + "\n" +
                "Odometer: " + odometer + "\n" +
                "Price: " + price + "\n";
    }
}
