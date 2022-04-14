package design_1.model;

import design_1.constants.TaskStatus;

public class Task {
    Integer id;
    Long startDate;
    Long lastUpdatedDate;
    Customer customer;
    SalesMan salesMan;
    TaskStatus status;
    public void setId(Integer id) {
        this.id = id;
    }
    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public void setLastUpdatedDate(Long lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSalesMan(SalesMan salesMan) {
        this.salesMan = salesMan;
    }

    public Customer getCustomer() {
        return customer;
    }

    public SalesMan getSalesMan() {
        return salesMan;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public Long getLastUpdatedDate() {
        return lastUpdatedDate;
    }
}
