package design_1;

import design_1.constants.CustomerStatus;
import design_1.model.Task;
import design_1.service.CustomerService;
import design_1.service.SalesService;
import design_1.service.TaskManagementService;
import design_1.service.TaskService;
import design_1.utils.CommonUtil;

public class Driver {
    public static void main(String[] args){
        TaskManagementService taskManagementService=new TaskManagementService();
            taskManagementService.salesService=new SalesService();
            taskManagementService.taskService=new TaskService();
            taskManagementService.customerService=new CustomerService();
            Integer customer_1=taskManagementService.addCustomer("Customer_1", "customer_1@a.a");
            Integer customer_2=taskManagementService.addCustomer("Customer_2", "customer_2@a.a");
            Integer saleman_1=taskManagementService.addSalesMan("SaleMan_1", "saleman_1@a.a");
            Long time=System.currentTimeMillis()+ CommonUtil.getMillisForDays(9L);
            Integer task_1=taskManagementService.addTask(taskManagementService.getCustomer(customer_1), taskManagementService.getSalesMan(saleman_1), time);
            Integer task_2=taskManagementService.addTask(taskManagementService.getCustomer(customer_2), taskManagementService.getSalesMan(saleman_1), time);
            Integer followup_task_1=taskManagementService.updateTaskStatus(task_1, CustomerStatus.HOT, time+1001);
            taskManagementService.updateTaskStatus(task_2, CustomerStatus.CLOSED, time+1002);
            taskManagementService.updateTaskStatus(followup_task_1, CustomerStatus.COMPLETED, time+CommonUtil.getMillisForDays(1L));
            taskManagementService.updateTaskStatus(task_2, CustomerStatus.CLOSED, time+1002);
            System.out.println(taskManagementService.getIncentive(Long.valueOf(saleman_1), time+CommonUtil.getMillisForDays(1L)+1003));
            System.out.println(taskManagementService.getTasks(saleman_1, time+CommonUtil.getMillisForDays(1L)+1003));
            System.out.println(taskManagementService.getAllTasks());
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