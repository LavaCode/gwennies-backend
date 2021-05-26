package com.gwennies.eindopdracht.repository;

import java.util.Collection;
import java.util.Optional;

import com.gwennies.eindopdracht.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Collection<User> findAllByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
