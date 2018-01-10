package com.future.springh2.services.impl;

import com.future.springh2.model.Customer;
import com.future.springh2.repositories.CustomerRepository;
import com.future.springh2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer register(String name, String address) {

        Customer customer = new Customer();
        customer.setName(name);
        customer.setAddress(address);
        customer.setId(UUID.randomUUID().toString());

        return customerRepository.save(customer);
//        coba test save kalo diubah
//        return customer;
    }

    @Transactional(readOnly = true)
    @Override
    public Customer getCustomer(String id) {
        return customerRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(String id, String name, String address) {
        Customer customer = customerRepository.findOne(id);
        customer.setName(name);
        customer.setAddress(address);
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public Customer deleteCustomer(String id) {
        Customer customer = customerRepository.findOne(id);
        customerRepository.delete(customer);
        return customer;
    }

}
