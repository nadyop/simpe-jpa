package com.future.springh2.controllers;

import com.future.springh2.model.Customer;
import com.future.springh2.requests.RegisterCustomerRequest;
import com.future.springh2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

// @RestController -> terdapat @ResponseBody return json, @Controller return template
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

//    register
    @RequestMapping(
            value = "/customers",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, //content type
            consumes = MediaType.APPLICATION_JSON_VALUE)
//    consumes hanya untuk yg butuh RequestBody

    public Customer register(@Valid @RequestBody RegisterCustomerRequest request){
        return customerService.register(request.getName(), request.getAddress());
    }

//    get
    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE //content type
    )

    public Customer getCustomer(@PathVariable(value = "id") String id){
        return customerService.getCustomer(id);
    }

//    update
    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE, //content type
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public Customer updateCustomer(@PathVariable(value = "id") String id,
                                   @Valid @RequestBody RegisterCustomerRequest request){
        return customerService.updateCustomer(id, request.getName(), request.getAddress());
    }

//    get All
    @RequestMapping(
            value = "/customers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE //content type
    )

    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

//    delete
    @RequestMapping(
            value = "/customers/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE //content type
    )

    public Customer deleteCustomer(@PathVariable(value = "id") String id){
        return customerService.deleteCustomer(id);
    }
}
