package design_1.model;

import design_1.constants.TaskStatus;
import design_1.constants.TaskType;

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

    public Integer getId() {
        return id;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", customer=" + customer.email +
                ", salesMan=" + salesMan.email +
                ", status=" + status +
                '}';
    }

    public Long getStartDate() {
        return startDate;
    }
}
