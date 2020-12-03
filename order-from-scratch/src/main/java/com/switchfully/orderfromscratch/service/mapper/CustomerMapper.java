package com.switchfully.orderfromscratch.service.mapper;

import com.switchfully.orderfromscratch.domain.Address;
import com.switchfully.orderfromscratch.domain.Customer;
import com.switchfully.orderfromscratch.service.dto.AddressDto;
import com.switchfully.orderfromscratch.service.dto.CustomerDto;
import com.switchfully.orderfromscratch.service.dto.GetCustomerDto;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer convertCustomerDtoToCustomer(CustomerDto customerDto){
        return new Customer(customerDto.getFirstName(), customerDto.getLastName(), customerDto.getEmailAddress(),
                new Address(customerDto.getAddress().getStreetName(),
                        customerDto.getAddress().getStreetNumber(),
                        customerDto.getAddress().getPostalCode(),
                        customerDto.getAddress().getCity(),
                        customerDto.getAddress().getCountry()), customerDto.getPhoneNumber());
    }

    public CustomerDto convertCustomerToCustomerDto(Customer customer){

        AddressDto addressDto = new AddressDto();
        addressDto.setStreetName(customer.getAddress().getStreetName());
        addressDto.setStreetNumber(customer.getAddress().getStreetNumber());
        addressDto.setPostalCode(customer.getAddress().getPostalCode());
        addressDto.setCity(customer.getAddress().getCity());
        addressDto.setCountry(customer.getAddress().getCountry());
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setEmailAddress(customer.getEmailAddress());
        customerDto.setAddress(addressDto);
        customerDto.setPhoneNumber(customer.getPhoneNumber());

        return customerDto;
    }

    public GetCustomerDto convertCustomerToGetCustomerDto(Customer customer){


        AddressDto addressDto = new AddressDto();
        addressDto.setStreetName(customer.getAddress().getStreetName());
        addressDto.setStreetNumber(customer.getAddress().getStreetNumber());
        addressDto.setPostalCode(customer.getAddress().getPostalCode());
        addressDto.setCity(customer.getAddress().getCity());
        addressDto.setCountry(customer.getAddress().getCountry());

        GetCustomerDto getCustomerDto = new GetCustomerDto();
        getCustomerDto.setFirstName(customer.getFirstName());
        getCustomerDto.setLastName(customer.getLastName());
        getCustomerDto.setEmailAddress(customer.getEmailAddress());
        getCustomerDto.setAddress(addressDto);
        getCustomerDto.setPhoneNumber(customer.getPhoneNumber());
        getCustomerDto.setId(customer.getId());
        return getCustomerDto;
    }
}
