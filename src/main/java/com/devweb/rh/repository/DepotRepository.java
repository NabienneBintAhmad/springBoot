package com.devweb.rh.repository;

import com.devweb.rh.model.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DepotRepository extends JpaRepository<Depot, Integer> {


}