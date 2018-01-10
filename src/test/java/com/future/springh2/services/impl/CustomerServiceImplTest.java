package com.future.springh2.services.impl;

import com.future.springh2.model.Customer;
import com.future.springh2.repositories.CustomerRepository;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import javax.validation.constraints.NotNull;

import static org.junit.Assert.*;

public class CustomerServiceImplTest {

//    bawaan spring untuk dapat membaca @Mock dan @InjectMocks
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

//    mock kalo belum dikasih behaviour bakalan return null
    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void testRegisterSuccess() {
//        index 0 karena dia bakal ngembaliin ke objek customernya
        Mockito.when(customerRepository.save(Mockito.any(Customer.class)))
                .then(invocation ->{
                    return invocation.getArguments()[0];
                });

        Customer customer = customerService.register("Nadya", "Yogyakarta");

//        validasi / memastikan
        assertNotNull(customer.getId());
        assertEquals("Nadya",customer.getName());
        assertEquals("Yogyakarta",customer.getAddress());

//        verifikasi method save
        Mockito.verify(customerRepository, Mockito.times(1))
                .save(Mockito.any(Customer.class));
    }

    @Test(expected = RuntimeException.class)
    public void testRegisterError() {
        Mockito.when(customerRepository.save(Mockito.any(Customer.class)))
                .thenThrow(new RuntimeException());

        customerService.register("Nadya", "Yogyakarta");
    }

//    @Test
//    public void testUpdateSuccess() {
//        Mockito.when(customerRepository.save(Mockito.any(Customer.class)))
//                .then(invocation -> invocation.getArguments()[0]);
//        Customer customer = customerService.updateCustomer(, "Mail", "Wirobrajan")
//    }
}