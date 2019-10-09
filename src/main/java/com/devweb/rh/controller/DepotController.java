package com.devweb.rh.controller;

import com.devweb.rh.model.Compte;
import com.devweb.rh.model.Depot;
import com.devweb.rh.model.DepotIntermédiaire;
import com.devweb.rh.model.User;
import com.devweb.rh.repository.CompteRepository;
import com.devweb.rh.repository.DepotRepository;
import com.devweb.rh.repository.UserRepository;
import com.devweb.rh.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class DepotController {


        @Autowired
        private UserDetailsServiceImpl userDetailsService;
        @Autowired
        private DepotRepository depotRepository;
        @Autowired
        private UserRepository userRepository;
       @Autowired
        private CompteRepository compteRepository;
        @PostMapping( "/depot")
        public String add(DepotIntermédiaire d) throws Exception{


            Depot depot = new Depot();

            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
            Date now = new Date();
            String date = formater.format(now);
            //depot.setDate(date);

            if(d.getMontant()>=75000){
                depot.setDate(date);
                depot.setMontant(d.getMontant());
                //User ucon = userDetailsService.getUserconnecte();
                // d.setUser(ucon);

                Compte compte = compteRepository.findCompteByNumero(d.getNumero()).orElseThrow(
                        ()-> new Exception("Compte invalide!!!" ));
                compte.setSolde(depot.getMontant()+compte.getSolde());
              if (d.getNumero()==(compte.getNumero())) {
                    depot.setCompte(compte);
                }
              //Compte cmpt= new Compte();
              // depot.setCompte(compte);
              //  cmpt.setSolde(d.getMontant()+compte.getSolde());
             User user = userDetailsService.getCeluiConnnecter();
               depot.setCaissier(user.getCaissier());
                compteRepository.save(compte);
                depotRepository.save(depot);
            }else {
                return "le montant doit etre supérieur ou égal  à 75000";
            }
            return "Depot effectué avec succès !!";
        }
    }
