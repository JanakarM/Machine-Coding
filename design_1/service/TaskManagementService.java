package design_1.service;


import java.util.List;
import java.util.Map;

import design_1.constants.CommonConstants;
import design_1.constants.CustomerStatus;
import design_1.model.Customer;
import design_1.model.SalesMan;
import design_1.model.Task;
import design_1.utils.CommonUtil;

public class TaskManagementService extends CommonConstants{
    CustomerService customerService;
    SalesService salesService;
    TaskService taskService;
    void addSalesMan(String name, String email){
        salesService.addSalesMan(name, email);
    }
    void removeSalesMan(Integer salesManId){
        salesService.removeSalesMan(salesManId);
    }
    void updateAvailability(Integer salesManId, boolean status){
        salesService.updateAvailability(salesManId, status);
    }
    void addCustomer(String name, String email){
        customerService.addCustomer(name, email);
    }
    void removeCustomer(Integer customerId){
        customerService.removeCustomer(customerId);
    }
    void addTask(Customer customer, SalesMan salesMan, Long date){
        taskService.createTask(customer, salesMan, System.currentTimeMillis()+ CommonUtil.getMillisForDays(7L));
    }
    void updateTaskStatus(Integer taskId, CustomerStatus customerStatus, Long date) {
        taskService.updateTaskStatus(taskId, customerStatus, date);
        if(customerStatus==CustomerStatus.COMPLETED){
            salesService.addIncentive(1L, date, CommonConstants.incentiveAmount);
        }
    }
    Long getIncentive(Long salesManId, Long date){
        return salesService.getIncentive(salesManId, date);
    }
    Map<String, List<Task>> getTasks(Integer salesManId, Long date){
        return taskService.getTasks(salesManId, date);
    }
}
