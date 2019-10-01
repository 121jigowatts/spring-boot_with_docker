package com.jigowatts.springboot_with_docker.controllers;

import com.jigowatts.springboot_with_docker.domain.Customer;
import com.jigowatts.springboot_with_docker.repositories.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloApiController
 */
@RestController
public class HelloApiController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping("/")
    public String index() {
        return "Welcome to SPRING BOOT with Docker.";
    }

    @RequestMapping("api/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name + "!";
    }

    @RequestMapping("api/customer/{firstName}")
    public String getCustomer(@PathVariable String firstName) {
        Customer customer = repository.findByFirstName(firstName);
        if (customer == null) {
            return "Sorry.not found.";
        } else {
            return String.format("Hello %s %s!", customer.firstName, customer.lastName);
        }
    }

}
