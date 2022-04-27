package service;

import model.Booking;
import model.Customer;
import model.Vehicle;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public class ZoomCarService {
    public CustomerService customerService;
    public VehicleService vehicleService;
    public BookingService bookingService;
    public AddOnService addOnService;
    public ZoomCarService(){

    }
    public int addCustomer(String name, String email){
        return customerService.addCustomer(name, email);
    }
    public Collection<Customer> listAllCustomers(){
        return customerService.listAllCustomers();
    }
    public int addVehicle(String vehicleType, String regNo){
        return vehicleService.addVehicle(vehicleType, regNo);
    }
    public Collection<Vehicle> listAllVehicles(){
        return vehicleService.listAllVehicles();
    }
    public int addBooking(int vehicleId, int customerId, String startTime) throws IllegalStateException{
        Vehicle vehicle=vehicleService.getVehicle(vehicleId);
        if(!vehicle.isAvailable()){
            throw new IllegalStateException("Selected Vehicle not available");
        }
        return bookingService.addBooking(vehicle, customerService.getCustomer(customerId), startTime);
    }
    public Collection<Booking> listAllBookings(){
        return bookingService.listAllBookings();
    }
    public void setAvailable(int vehicleId){
        vehicleService.setAvailable(vehicleId, true);
    }
    public void setUnAvailable(int vehicleId){
        vehicleService.setAvailable(vehicleId, false);
    }
    public void returnVehicle(int bookingId, String endTime){
        bookingService.returnVehicle(bookingService.getBooking(bookingId), endTime);
    }
    public String getInvoice(int bookingId){
        StringBuilder sb=new StringBuilder();
        Booking booking=bookingService.getBooking(bookingId);
        sb.append("Id: " + booking.getId());
        sb.append("\n");
        sb.append("Customer Email: " + booking.getCustomer().getEmail());
        sb.append("\n");
        sb.append("Vehicle Number: " + booking.getVehicle().getRegistrationNumber());
        sb.append("\n");
        sb.append("Vehicle Type: " + booking.getVehicle().getType());
        sb.append("\n");
        sb.append("Cost: " + bookingService.getCharges(booking));
        sb.append("\n");
        return sb.toString();
    }
    public List<Booking> getBookingsForUser(int customerId){
        return bookingService.getBookingsForUser(customerId);
    }
    public List<Booking> getBookingsForUser(int customerId, String startDate, String endDate){
        return bookingService.getBookingsForUser(customerId, startDate, endDate);
    }
}