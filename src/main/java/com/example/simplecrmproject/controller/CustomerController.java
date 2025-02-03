package com.example.simplecrmproject.controller;

import com.example.simplecrmproject.model.Customer;
import com.example.simplecrmproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String viewCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "viewCustomers";
    }

    @GetMapping("/add")
    public String addCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    @PostMapping("/add")
    public String addCustomer(Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }
}
