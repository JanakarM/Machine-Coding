package design_1.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import design_1.constants.CommonConstants;
import design_1.constants.CustomerStatus;
import design_1.constants.TaskStatus;
import design_1.model.Customer;
import design_1.model.SalesMan;
import design_1.model.Task;
import design_1.utils.CommonUtil;

public class TaskService extends CommonConstants {
    Map<Integer, Task> tasksList=new HashMap<>();
    Map<Integer, List<Task>> salesManVsTasks=new HashMap<>();
    Task createTask(Customer customer, SalesMan salesMan, Long date){
        int taskId=taskIds.incrementAndGet();
        Task task=new Task();
        task.setId(taskId);
        task.setCustomer(customer);
        task.setSalesMan(salesMan);
        task.setStatus(TaskStatus.NEW);
        Long dateMillis=CommonUtil.getDateEquivalent(date);
        task.setStartDate(dateMillis);
        task.setLastUpdatedDate(dateMillis);
        tasksList.put(taskId, task);
        if(!salesManVsTasks.containsKey(salesMan.getId())){
            salesManVsTasks.put(salesMan.getId(), new ArrayList<>());
        }
        salesManVsTasks.get(salesMan.getId()).add(task);
        return task;
    }
    void updateTaskStatus(Integer taskId, CustomerStatus customerStatus, Long date){
        Task task=tasksList.get(taskId);
        CustomerStatus customerStatusFinal=customerStatus;
        Long dateMillis=CommonUtil.getDateEquivalent(date);
        if(customerStatus==CustomerStatus.COLD && task.getCustomer().getStatus()==CustomerStatus.COLD){
            task.setStatus(TaskStatus.NO_CONVERSION);
            customerStatusFinal=CustomerStatus.CLOSED;
        }else if(customerStatus!=CustomerStatus.COMPLETED){
            Task followUpTask=createTask(task.getCustomer(), task.getSalesMan(), dateMillis);
            followUpTask.setStatus(TaskStatus.FOLLOW_UP);
            customerStatusFinal=customerStatus;
            task.setStatus(TaskStatus.FOLLOW_UP_TASK_SCHEDULED);
        }
        task.getCustomer().setStatus(customerStatusFinal);
        task.setLastUpdatedDate(dateMillis);
        task.getCustomer().setLastUpdatedTime(dateMillis);
    }
    Map<String, List<Task>> getTasks(Integer salesManId, Long date){
        List<Task> open=new ArrayList<>();
        List<Task> closed=new ArrayList<>();
        Map<String, List<Task>> taskSummary=new HashMap<>();
        Long dateMillis=CommonUtil.getDateEquivalent(date);
        for(Task t:salesManVsTasks.get(salesManId)){
            if(!dateMillis.equals(t.getLastUpdatedDate())){
                continue;
            }
            if(t.getStatus()==TaskStatus.CONVERSION || t.getStatus()==TaskStatus.NO_CONVERSION){
                closed.add(t);
            }else {
                open.add(t);
            }
            taskSummary.put("OPEN", open);
            taskSummary.put("CLOSED", closed);
        }
        return taskSummary;
    }
}
