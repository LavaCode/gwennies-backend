package com.gwennies.eindopdracht.repository;

import com.gwennies.eindopdracht.domain.FileDB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
