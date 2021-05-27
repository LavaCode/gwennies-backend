package com.gwennies.eindopdracht.service;

import java.util.Collection;
import java.util.Optional;

import com.gwennies.eindopdracht.domain.User;

public interface UserService {
    long createUser(User user);
    void updateUser(long id, User user);
    void deleteUser(long id);
    Collection<User> getUsers(String username);
    Optional<User> getUserById(long id);
    boolean userExistsById(long id);
}
