package com.devweb.rh.repository;

import com.devweb.rh.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByMatriculee(String matriculee);
    Boolean existsByMatriculee(String matriculee);
    Boolean existsByStatut(String statut);
}
