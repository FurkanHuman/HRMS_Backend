package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.SchoolType;

public interface SchoolTypeDao extends JpaRepository<SchoolType, Integer> {

    SchoolType findByName(String name);

}
