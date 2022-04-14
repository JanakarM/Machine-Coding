package design_1.model;

import design_1.constants.CustomerStatus;

public class Customer extends User{
    CustomerStatus status;
    Long lastUpdatedTime;
    public Customer(Integer id, String name, String email, CustomerStatus customerStatus) {
        super(id, name, email);
        status=customerStatus;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }

    public void setLastUpdatedTime(Long lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }
}
