package com.gwennies.eindopdracht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import com.gwennies.eindopdracht.domain.User;
import com.gwennies.eindopdracht.exceptions.RecordNotFoundException;
import com.gwennies.eindopdracht.repository.UserRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> getCustomers(String customer_number) {
        if (customer_number != null && !customer_number.isEmpty()) {
            return userRepository.findAllByCustomerNumber(customer_number);
        }
        else {
            return userRepository.findAll();
        }
    }

    // @Override
    // public long createCustomer(User customer) {
    //     User newCustomer = userRepository.save(customer);
    //     return newCustomer.getId();
    // }

    // @Override
    // public void updateCustomer(long id, User newCustomer) {
    //     Optional<User> optionalCustomer = userRepository.findById(id);
    //     User customer;
    //     if (optionalCustomer.isPresent()) {
    //         customer = optionalCustomer.get();
    //         customer.setUsername(newCustomer.getUsername());
    //         userRepository.save(customer);
    //     }
    //     else {
    //         throw new RecordNotFoundException();
    //     }
    // }

    // @Override
    // public void deleteCustomer(long id) {
    //     if (!userRepository.existsById(id)) throw new RecordNotFoundException();
    //     userRepository.deleteById(id);
    // }

    // @Override
    // public Optional<User> getCustomerById(long id) {
    //     if (!userRepository.existsById(id)) throw new RecordNotFoundException();
    //     return userRepository.findById(id);
    // }

    // @Override
    // public boolean customerExistsById(long id) {
    //     return userRepository.existsById(id);
    // }

}
