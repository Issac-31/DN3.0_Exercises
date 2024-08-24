package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.dto.CustomerDTO;
import com.example.BookstoreAPI.mapper.CustomerMapper;
import com.example.BookstoreAPI.model.Customer;
import com.example.BookstoreAPI.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        Customer customer = CustomerMapper.INSTANCE.toCustomer(customerDTO);
        customer = customerRepository.save(customer);
        return CustomerMapper.INSTANCE.toCustomerDTO(customer);
    }

    // Read All
    @GetMapping
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerMapper.INSTANCE::toCustomerDTO)
                .collect(Collectors.toList());
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
        return customerRepository.findById(id)
                .map(customer -> ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(customer)))
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable int id, @Valid @RequestBody CustomerDTO customerDTO) {
        return customerRepository.findById(id)
                .map(customer -> {
                    Customer updatedCustomer = CustomerMapper.INSTANCE.toCustomer(customerDTO);
                    updatedCustomer.setId(customer.getId());  // Ensure ID is the same
                    updatedCustomer.setVersion(customer.getVersion());  // Ensure version is the same
                    customerRepository.save(updatedCustomer);
                    return ResponseEntity.ok(CustomerMapper.INSTANCE.toCustomerDTO(updatedCustomer));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable int id) {
        return customerRepository.findById(id)
                .map(customer -> {
                    customerRepository.delete(customer);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
