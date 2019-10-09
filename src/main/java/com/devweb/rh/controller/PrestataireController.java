package com.devweb.rh.controller;

import com.devweb.rh.model.Prestataire;
import com.devweb.rh.repository.PrestataireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class PrestataireController {

    @Autowired
    private PrestataireRepository prestataireRepository;
    @GetMapping(value = "/listpresta")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Prestataire> liste(){
        return prestataireRepository.findAll();
    }
    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Prestataire add(@RequestBody(required = false) Prestataire prestataire){
        Prestataire p = new Prestataire();
        p.setNom(prestataire.getNom());
        p.setPrenom(prestataire.getPrenom());
        p.setNomEntreprise(prestataire.getNomEntreprise());
        p.setMatricule(prestataire.getMatricule());
        p.setCni(prestataire.getCni());
        p.setNinea(prestataire.getNinea());
        p.setAdresse(prestataire.getAdresse());
        p.setEmail(prestataire.getEmail());
        p.setContact(prestataire.getContact());
        return prestataireRepository.save(p);
    }

}
