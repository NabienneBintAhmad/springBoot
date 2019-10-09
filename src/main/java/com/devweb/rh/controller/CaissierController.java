package com.devweb.rh.controller;

import com.devweb.rh.model.Caissier;
import com.devweb.rh.model.RegisterIntermédiaire;
import com.devweb.rh.model.Role;
import com.devweb.rh.model.User;
import com.devweb.rh.repository.CaissierRepository;
import com.devweb.rh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class CaissierController {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CaissierRepository caissierRepository;
    @GetMapping(value = "/listecaisssier" +
            "")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public List<Caissier> liste(){
        return caissierRepository.findAll();
    }

    @PostMapping(value = "/caissier")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public Caissier add(RegisterIntermédiaire registerIntermédiaire) {

        Caissier c = new Caissier();

        c.setNomm(registerIntermédiaire.getNomm());
        c.setPrenomm(registerIntermédiaire.getPrenomm());
        c.setMatriculee(registerIntermédiaire.getMatriculee());
        c.setCnii(registerIntermédiaire.getCnii());
        c.setAdressee(registerIntermédiaire.getAdressee());
        c.setEmaill(registerIntermédiaire.getEmaill());
        c.setContactt(registerIntermédiaire.getContactt());



         User u =new User();

        u.setUsername(registerIntermédiaire.getUsername());

        u.setStatut("Debloquer");
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId((long) 3);
        roles.add(role);
        u.setRoles(roles);
        u.setCaissier(c);
        u.setPassword (encoder.encode(registerIntermédiaire.getPassword()));
        //prestataireRepository.save(p);
        caissierRepository.save(c);
        userRepository.save(u);


        return   caissierRepository.save(c);
    }
}