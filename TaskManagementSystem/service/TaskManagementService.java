package design_1.service;


import java.util.List;
import java.util.Map;

import design_1.constants.CommonConstants;
import design_1.constants.CustomerStatus;
import design_1.model.Customer;
import design_1.model.SalesMan;
import design_1.model.Task;
import design_1.utils.CommonUtil;

public class TaskManagementService{
    public CustomerService customerService;
    public SalesService salesService;
    public TaskService taskService;
    public Integer addSalesMan(String name, String email){
        return salesService.addSalesMan(name, email);
    }
    public void removeSalesMan(Integer salesManId){
        salesService.removeSalesMan(salesManId);
    }
    public void updateAvailability(Integer salesManId, boolean status){
        salesService.updateAvailability(salesManId, status);
    }
    public Integer addCustomer(String name, String email){
        return customerService.addCustomer(name, email);
    }
    public void removeCustomer(Integer customerId){
        customerService.removeCustomer(customerId);
    }
    public Integer addTask(Customer customer, SalesMan salesMan, Long date){
        long thresholdDate=System.currentTimeMillis();
        thresholdDate+=CommonUtil.getMillisForDays(7L);
        if(date<=thresholdDate){
           throw new IllegalStateException("Task should be created before 7 days");
        }
        return taskService.createTask(customer, salesMan, date).getId();
    }
    public Integer updateTaskStatus(Integer taskId, CustomerStatus customerStatus, Long date) {
        Integer followTaskId=taskService.updateTaskStatus(taskId, customerStatus, date);
        if(customerStatus==CustomerStatus.COMPLETED){
            salesService.addIncentive(Long.valueOf(taskService.tasksList.get(taskId).getSalesMan().getId()), date, CommonConstants.incentiveAmount);
        }
        return followTaskId;
    }
    public Long getIncentive(Long salesManId, Long date){
        return salesService.getIncentive(salesManId, date);
    }
    public Map<String, List<Task>> getTasks(Integer salesManId, Long date){
        return taskService.getTasks(salesManId, date);
    }
    public SalesMan getSalesMan(Integer salesManId) {
        return salesService.getSalesMan(salesManId);
    }
    public Customer getCustomer(Integer id){
        return customerService.getCustomer(id);
    }
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
}
