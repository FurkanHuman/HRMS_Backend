package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {

}
