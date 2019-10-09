package com.devweb.rh.repository;

import com.devweb.rh.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompteRepository  extends JpaRepository<Compte, Integer> {
    Optional<Compte> findCompteByNumero (int numero);

}
