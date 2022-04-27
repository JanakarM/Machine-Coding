package service;

import constants.CommonConstants;
import model.Booking;
import model.Customer;
import model.Vehicle;
import util.CommonUtil;

import java.util.*;

public class BookingService {
    Map<Integer, Booking> bookings=new HashMap<>();
    public BookingService(){

    }
    int addBooking(Vehicle vehicle, Customer customer, String startTime){
        int bookingId= CommonConstants.bookingIds++;
        Booking booking=new Booking(bookingId, vehicle, customer, startTime);
        vehicle.setAvailable(false);
        bookings.put(bookingId, booking);
        return bookingId;
    }
    Collection<Booking> listAllBookings(){
        return bookings.values();
    }
    Booking getBooking(int id){
        return bookings.get(id);
    }

    void returnVehicle(Booking booking, String endTime){
        booking.getVehicle().setAvailable(true);
        booking.setEndTime(endTime);
        String startTime=booking.getStartTime();
        int totalHours= CommonUtil.calculateHours(startTime, endTime);
        int amount=(int)Math.ceil((double)totalHours/CommonConstants.minimumDuration)*CommonConstants.baseFee;
        booking.setCharges(amount);
    }

    int getCharges(Booking booking){
        return booking.getCharges();
    }
    List<Booking> getBookingsForUser(int customerId){
        List<Booking> bookingList=new ArrayList<>();
        bookings.forEach((a, b)->{
            if(b.getCustomer().getId()==customerId){
                bookingList.add(b);
            }
        });
        return bookingList;
    }

    List<Booking> getBookingsForUser(int customerId, String startDate, String endDate){
        List<Booking> bookingList=new ArrayList<>();
        bookings.forEach((a, b)->{
            if(b.getCustomer().getId()==customerId){
                if(b.getStartTime().compareTo(startDate)>=0 && b.getEndTime().compareTo(endDate)<=0) {
                    bookingList.add(b);
                }
            }
        });
        return bookingList;
    }
}