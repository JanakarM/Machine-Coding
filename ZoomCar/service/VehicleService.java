package service;

import constants.CommonConstants;
import constants.VehicleType;
import model.Booking;
import model.Customer;
import model.Vehicle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VehicleService {
    Map<Integer, Vehicle> vehicles=new HashMap<>();
    public VehicleService(){

    }
    int addVehicle(String vehicleType, String regNo){
        int vehicleId= CommonConstants.vehicleIds++;
        Vehicle vehicle=new Vehicle(vehicleId, VehicleType.valueOf(vehicleType), regNo);
        vehicles.put(vehicleId, vehicle);
        return vehicleId;
    }
    Collection<Vehicle> listAllVehicles(){
        return vehicles.values();
    }
    Vehicle getVehicle(int id){
        return vehicles.get(id);
    }
    void setAvailable(int vehicleId, boolean status){
        vehicles.get(vehicleId).setAvailable(status);
    }
}
