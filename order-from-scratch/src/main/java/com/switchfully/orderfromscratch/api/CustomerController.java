package com.switchfully.orderfromscratch.api;

import com.switchfully.orderfromscratch.service.CustomerService;
import com.switchfully.orderfromscratch.service.dto.GetCustomerDto;
import com.switchfully.orderfromscratch.service.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CustomerDto customerDto){
        customerService.createCustomer(customerDto);
        }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetCustomerDto> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
