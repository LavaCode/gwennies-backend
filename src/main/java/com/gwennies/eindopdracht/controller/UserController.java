package com.gwennies.eindopdracht.controller;

import java.util.Optional;

import com.gwennies.eindopdracht.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin
public class UserController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getUsers(@RequestParam(name="customer_number", required=false) String customer_number) {
        return ResponseEntity.ok().body(customerService.getCustomers(customer_number));
    }

    // @GetMapping(value = "/{id}")
    // public ResponseEntity<Optional<Customer>> getCustomer(@PathVariable("id") int id) {
    //     return ResponseEntity.ok().body(customerService.getCustomerById(id));
    // }

    // @PostMapping(value = "")
    // public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
    //     long newId = customerService.createCustomer(customer);

    //     URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
    //             .buildAndExpand(newId).toUri();

    //     return ResponseEntity.created(location).build();
    // }

    // @PutMapping(value = "/{id}")
    // public ResponseEntity<Object> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
    //     customerService.updateCustomer(id, customer);
    //     return ResponseEntity.noContent().build();
    // }

    // @DeleteMapping(value = "/{id}")
    // public ResponseEntity<Object> deleteCustomer(@PathVariable("id") int id) {
    //     customerService.deleteCustomer(id);
    //     return ResponseEntity.noContent().build();
    // }

}
