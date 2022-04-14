package design_1;

public class Driver {
    public static void main(String[] args){

    }
}

/*
    User
        Id
        Email
        Name

    SalesMan extends User
        isAvailable
        joiningDate

    enum CustomerStatus
        NEW
        HOT
        WARM
        COLD
        CLOSED
        COMPLETED

    Customer extends User
        CustomerStatus

    enum TaskType
        TALKING_TO_CUSTOMER

    TaskStatus
        NEW
        FOLLOW_UP
        COMPLETED

    Task
        TaskType
        SalesMan
        Customer
        StartDate
        LastUpdatedTime
        TaskStatus

    TaskManagementService
        SalesService
        CustomerService
        List<SalesMan.Id, Task>

        addCustomer()
        addCustomer()
        removeCustomer()
        addSalesMan()
        removeSalesMan()
        updateAvailability()
        addTask()
        updateTask(details...)
        numberPfTasksBySalesMan(SalesMan.Id, Date)
        incentivesBySalesMan(SalesMan.Id, Date)

    SalesService
        List<SalesMan>
        List<Date, Incentive>
        addSalesMan(details..)
        removeSalesMan(id)
        updateAvailability(status)

    CustomerService
        List<Customers>
        addCustomer()
        removeCustomer()

 */