package design_1.model;

public class SalesMan extends User{
    boolean isAvailable;
    Long joinedDate;// millis will be considered
    public SalesMan(Integer id, String name, String email, boolean isAvailable, Long joinedDate) {
        super(id, name, email);
        this.isAvailable=isAvailable;
        this.joinedDate=joinedDate;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
