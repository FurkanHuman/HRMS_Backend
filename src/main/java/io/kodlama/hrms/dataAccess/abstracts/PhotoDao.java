package io.kodlama.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.kodlama.hrms.entities.concretes.Photo;

public interface PhotoDao extends JpaRepository<Photo, Integer> {

    List<Photo> findByUserId(int candidateId);

    String findBylink(int photoId);

    boolean existsByUserId(int candidateUserId);

    Photo getByUserId(int candidateUserId);
}
