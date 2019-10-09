package com.devweb.rh.repository;

import com.devweb.rh.model.UserPrestataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserprestataireRepository extends JpaRepository<UserPrestataire, Integer> {

}