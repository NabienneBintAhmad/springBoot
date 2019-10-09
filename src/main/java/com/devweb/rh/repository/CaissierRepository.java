package com.devweb.rh.repository;

import com.devweb.rh.model.Caissier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CaissierRepository extends JpaRepository<Caissier, Integer> {

}