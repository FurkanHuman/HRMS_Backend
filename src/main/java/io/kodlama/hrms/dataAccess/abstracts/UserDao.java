package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.User;

public interface UserDao<T extends User> extends JpaRepository<T, Integer> {
    boolean existsByeMail(String email);
}
