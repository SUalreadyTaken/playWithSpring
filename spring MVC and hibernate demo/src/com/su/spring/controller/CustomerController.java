package com.su.spring.controller;

import com.su.spring.entity.Customer;
import com.su.spring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    // spring will scan for classes that implement CustomerService.. in this case CustomerServiceImpel
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public  String listCustomers(Model model) {

        List<Customer> customerList = customerService.getCustomers();

        model.addAttribute("customers", customerList);

        return "customers-list";
    }

    @GetMapping("customerForm")
    public String formAddCustomer(Model model) {

        Customer customer = new Customer();
        model.addAttribute("customer", customer);


        return "customer-form";
    }

    @PostMapping("saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);

        return "redirect:/customer/list";
    }

    @GetMapping("updateCustomer")
    public String updateCustomer(@RequestParam("customerId") int id, Model model) {

        Customer customer = customerService.getCustomer(id);

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("deleteCustomer")
    public String deleteCustomer(@RequestParam("customerId") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }


}
