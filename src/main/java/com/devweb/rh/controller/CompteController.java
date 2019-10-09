package com.devweb.rh.controller;

import com.devweb.rh.model.Compte;
import com.devweb.rh.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CompteController {
    @Autowired
    private CompteRepository compteRepository;
    @GetMapping(value = "/listcompte")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Compte> liste(){return compteRepository.findAll();
    }
    @PostMapping(value = "/compte",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Compte add(@RequestBody(required = false) Compte compte){
        Compte c = new Compte();
        SimpleDateFormat formater =new SimpleDateFormat("yyyy-MM-dd-hh-mm");
        Date now=new Date();
        String mat=formater.format(now);
        c.setNumero(compte.getNumero());
        c.setSolde(0);
        c.setDate(mat);
        return compteRepository.save(c);
    }
}
