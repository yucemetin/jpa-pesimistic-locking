package com.example.pesimisticlocking;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Transactional
    public void increment() {

        Customer customer = customerRepository.findByFirstName("metin");
        customer.setBalance(customer.getBalance().add(BigDecimal.ONE));
        //customerRepository.save(customer);
    }
}
