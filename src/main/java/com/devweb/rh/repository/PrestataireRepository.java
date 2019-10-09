package com.devweb.rh.repository;

import com.devweb.rh.model.Prestataire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestataireRepository extends JpaRepository<Prestataire, Integer> {


}