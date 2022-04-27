package model;

import constants.AddOnType;

public class AddOn {
    int id;
    String identifier;
    AddOnType type;
    boolean isAvailable;
    public AddOn(int id, String identifier, AddOnType type){
        this.id=id;
        this.identifier=identifier;
        this.type=type;
    }

    public int getId() {
        return id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public AddOnType getType() {
        return type;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
