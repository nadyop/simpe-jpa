package com.future.springh2.services;

import com.future.springh2.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer register(String name, String address);
    Customer getCustomer(String id);
    Customer updateCustomer(String id, String name, String address);
    void deleteCustomer(String id);
    List<Customer> getAllCustomer();

}
