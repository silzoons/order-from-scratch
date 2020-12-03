package com.switchfully.orderfromscratch.service;

import com.switchfully.orderfromscratch.domain.Customer;
import com.switchfully.orderfromscratch.repository.CustomerRepository;
import com.switchfully.orderfromscratch.service.dto.CustomerDto;
import com.switchfully.orderfromscratch.service.dto.GetCustomerDto;
import com.switchfully.orderfromscratch.service.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public void createCustomer(CustomerDto newCustomerDto){
        customerRepository.save(customerMapper.convertCustomerDtoToCustomer(newCustomerDto));
    }

    public List<GetCustomerDto> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers:: add);

        return customers.stream().map(customer -> customerMapper.convertCustomerToGetCustomerDto(customer)).collect(Collectors.toList());
    }
}
