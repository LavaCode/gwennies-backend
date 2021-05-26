package com.gwennies.eindopdracht.service;

import java.util.Collection;
import java.util.Optional;

import com.gwennies.eindopdracht.domain.User;

public interface CustomerService {
    // long createCustomer(User customer);
    // void updateCustomer(long id, User customer);
    // void deleteCustomer(long id);
    Collection<User> getCustomers(String customer_number);
    // Optional<User> getCustomerById(long id);
    // boolean customerExistsById(long id);
}
