package com.gwennies.eindopdracht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

import com.gwennies.eindopdracht.domain.User;
import com.gwennies.eindopdracht.exceptions.RecordNotFoundException;
import com.gwennies.eindopdracht.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private PasswordEncoder encoder;

    @Autowired
    public void setEncoder(PasswordEncoder passwordEncoder) {
        this.encoder = passwordEncoder;
    }

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<User> getUsers(String username) {
        if (username != null && !username.isEmpty()) {
            return userRepository.findAllByUsername(username);
        }
        else {
            return userRepository.findAll();
        }
    }

    @Override
    public long createUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getId();
    }

    @Override
    public void updateUser(long id, User newUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user;
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
            // user.setPassword(newUser.getPassword());
            user.setPassword(encoder.encode(newUser.getPassword()));
            userRepository.save(user);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteUser(long id) {
        if (!userRepository.existsById(id)) throw new RecordNotFoundException();
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> getUserById(long id) {
        if (!userRepository.existsById(id)) throw new RecordNotFoundException();
        return userRepository.findById(id);
    }

    @Override
    public boolean userExistsById(long id) {
        return userRepository.existsById(id);
    }

}
