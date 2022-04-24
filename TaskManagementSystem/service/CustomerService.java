package design_1.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import design_1.constants.CommonConstants;
import design_1.constants.CustomerStatus;
import design_1.model.Customer;

public class CustomerService extends CommonConstants {
    Map<Integer, Customer> customerList=new HashMap<>();
    Integer addCustomer(String name, String email){
        int customerId=userIds.incrementAndGet();
        Customer customer=new Customer(customerId, name, email, CustomerStatus.NEW);
        customerList.put(customerId, customer);
        return customerId;
    }
    void removeCustomer(Integer customerId){
        customerList.remove(customerId);
    }
    Customer getCustomer(Integer customerId){
        return customerList.get(customerId);
    }
}
