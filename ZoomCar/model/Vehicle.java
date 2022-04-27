package model;

import constants.VehicleType;

public class Vehicle {
    int id;
    VehicleType type;
    String registrationNumber;
    boolean isAvailable;
    public Vehicle(int id, VehicleType type, String registrationNumber){
        this.id=id;
        this.type=type;
        this.registrationNumber=registrationNumber;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public VehicleType getType() {
        return type;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", type=" + type +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
