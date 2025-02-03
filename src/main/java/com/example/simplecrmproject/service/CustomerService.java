package com.example.simplecrmproject.service;

import com.example.simplecrmproject.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customers.stream().filter(customer -> customer.getId().equals(id)).findFirst();
    }

    public Customer addCustomer(Customer customer) {
        customer.setId(counter.incrementAndGet());
        customers.add(customer);
        return customer;
    }

    public void updateCustomer(Customer customer) {
        customers.stream().filter(c -> c.getId().equals(customer.getId())).findFirst().ifPresent(existingCustomer -> {
            existingCustomer.setName(customer.getName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhone(customer.getPhone());
            existingCustomer.setAddress(customer.getAddress());
        });
    }

    public void deleteCustomer(Long id) {
        customers.removeIf(customer -> customer.getId().equals(id));
    }
}
