package com.example.BookstoreAPI.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.BookstoreAPI.model.Customer;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    @PostMapping("/register")
    public Customer registerCustomer(
            @RequestParam int id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone) {
        
        Customer customer = new Customer(id, name, email, phone);
        customers.add(customer);
        return customer;
    }
}
