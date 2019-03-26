package com.su.crmrest.rest;

import com.su.crmrest.entity.Customer;
import com.su.crmrest.exceptions.CustomerNotFoundException;
import com.su.crmrest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private final CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id) {

        Customer customer = customerService.getCustomer(id);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer with id " + id + " not found");
        }

        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {

        // id null,empty so saveOrUpdate will create new customer
        // just in case..
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
        //saveOrUpdate.. will update the existing customer
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {

        Customer tmpCustomer = customerService.getCustomer(id);

        if (tmpCustomer == null) {
            throw new CustomerNotFoundException("Customer with id " + id + " not found");
        }

        customerService.deleteCustomer(id);

        return "Deleted customer with id " + id;
    }

}
