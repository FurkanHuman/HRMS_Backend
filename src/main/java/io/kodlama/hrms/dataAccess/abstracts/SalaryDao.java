package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.Salary;

public interface SalaryDao extends JpaRepository<Salary, Integer> {

    boolean existsByscale(String scale);
}
