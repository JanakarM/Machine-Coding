package service;

import constants.AddOnType;
import constants.CommonConstants;
import constants.VehicleType;
import model.AddOn;
import model.Vehicle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AddOnService {
    Map<Integer, AddOn> addOns=new HashMap<>();
    public AddOnService(){

    }
    int addAddOn(String addOnType, String identifier){
        int addOnId= CommonConstants.addOnIds++;
        AddOn addOn=new AddOn(addOnId, identifier, AddOnType.valueOf(addOnType));
        addOns.put(addOnId, addOn);
        return addOnId;
    }
    AddOn getVehicle(int id){
        return addOns.get(id);
    }
    void setAvailable(int addOnId, boolean status){
        addOns.get(addOnId).setAvailable(status);
    }
}
