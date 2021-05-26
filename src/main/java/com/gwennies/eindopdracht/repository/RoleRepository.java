package com.gwennies.eindopdracht.repository;

import java.util.Optional;

import com.gwennies.eindopdracht.domain.EnumRoles;
import com.gwennies.eindopdracht.domain.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(EnumRoles name);
}
