package model;

import java.util.Date;
import java.util.List;

public class Booking {
    int id;
    Vehicle vehicle;
    List<AddOn> addOn;
    Customer customer;
    String startTime;
    String endTime;
    int charges;
    public Booking(int id, Vehicle vehicle, Customer customer, String startTime){
        this.id=id;
        this.vehicle=vehicle;
        this.customer=customer;
        this.startTime=startTime;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setCharges(int charges) {
        this.charges = charges;
    }

    public int getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", vehicle=" + vehicle.getRegistrationNumber() +
                ", customer=" + customer.getName() +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", charges='" + charges + '\'' +
                '}';
    }
}
