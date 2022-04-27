package service;

import constants.CommonConstants;
import model.Customer;
import model.Vehicle;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    Map<Integer, Customer> customers=new HashMap<>();
    public CustomerService(){

    }
    int addCustomer(String name, String email){
        int customerId= CommonConstants.userIds++;
        Customer customer=new Customer(customerId, name, email);
        customers.put(customerId, customer);
        return customerId;
    }
    Collection<Customer> listAllCustomers(){
        return customers.values();
    }
    Customer getCustomer(int id){
        return customers.get(id);
    }
}
