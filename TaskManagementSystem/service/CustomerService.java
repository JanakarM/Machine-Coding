package design_1.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import design_1.constants.CommonConstants;
import design_1.constants.CustomerStatus;
import design_1.model.Customer;

public class CustomerService extends CommonConstants {
    Map<Integer, Customer> customerList=new HashMap<>();
    void addCustomer(String name, String email){
        int customerId=userIds.incrementAndGet();
        Customer customer=new Customer(customerId, name, email, CustomerStatus.NEW);
        customerList.put(customerId, customer);
    }
    void removeCustomer(Integer customerId){
        customerList.remove(customerId);
    }
}
