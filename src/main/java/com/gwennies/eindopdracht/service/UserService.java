package com.gwennies.eindopdracht.service;

import java.util.Collection;
import java.util.Optional;

import com.gwennies.eindopdracht.domain.User;

public interface UserService {
    // long createCustomer(User customer);
    // void updateCustomer(long id, User customer);
    // void deleteCustomer(long id);
    Collection<User> getUsers(String username);
    Optional<User> getUserById(long id);
    // boolean customerExistsById(long id);
}
