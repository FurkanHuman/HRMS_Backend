package io.kodlama.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {

    Photo findByUserId(int candidateId);

    boolean existsByUserId(int candidateUserId);

    Photo getByUserId(int candidateUserId);
}
