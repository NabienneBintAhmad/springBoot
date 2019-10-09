package com.devweb.rh.controller;

import com.devweb.rh.model.*;
import com.devweb.rh.repository.AdminRepository;
import com.devweb.rh.repository.CompteRepository;
import com.devweb.rh.repository.PrestataireRepository;
import com.devweb.rh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class RegisterController {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    PrestataireRepository prestataireRepository;
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CompteRepository compteRepository;
    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public List<Prestataire> liste(){
        return prestataireRepository.findAll();
    }

    @PostMapping(value = "/register")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public Prestataire add( RegisterIntermédiaire registerIntermédiaire) {
        double nombre =(int) (Math.random() *999999999)+1;
        nombre *= 999999;
        Prestataire p = new Prestataire();


        p.setNom(registerIntermédiaire.getNom());
        p.setPrenom(registerIntermédiaire.getPrenom());
        p.setNomEntreprise(registerIntermédiaire.getNomEntreprise());
        p.setEmail(registerIntermédiaire.getEmail());
        p.setNinea(registerIntermédiaire.getNinea());
        p.setMatricule(registerIntermédiaire.getMatricule());
        p.setContact(registerIntermédiaire.getContact());
        p.setCni(registerIntermédiaire.getCni());
        p.setAdresse(registerIntermédiaire.getAdresse());
        p.setCompte((int) nombre);
        prestataireRepository.save(p);
       // prestataireRepository.save(p);

        Compte c = new Compte();
        c.setSolde(0);

        SimpleDateFormat formater = null;

        formater = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
        Date now = new Date();
        String date = formater.format(now);
        c.setNumero((int) nombre);
        c.setPrestataire(p);
        c.setDate(date);
        c.setSolde(0);

        Admin a = new Admin();

        a.setNomm(registerIntermédiaire.getNomm());
        a.setPrenomm(registerIntermédiaire.getPrenomm());
        a.setMatriculee(registerIntermédiaire.getMatriculee());
        a.setCnii(registerIntermédiaire.getCnii());
        a.setAdressee(registerIntermédiaire.getAdressee());
        a.setEmaill(registerIntermédiaire.getEmaill());
        a.setContactt(registerIntermédiaire.getContactt());
        a.setStatut("Debloquer");
        a.setPrestataire(p);


         User u =new User();

        u.setUsername(registerIntermédiaire.getUsername());

        u.setStatut("Debloquer");
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId((long) 1);
        roles.add(role);
        u.setRoles(roles);
        u.setPrestataire(p);
        u.setAdmin(a);
        u.setPassword (encoder.encode(registerIntermédiaire.getPassword()));
        //prestataireRepository.save(p);
        compteRepository.save(c);

        adminRepository.save(a);
        userRepository.save(u);


        return   prestataireRepository.save(p);
    }


    //Methode pour bloquer les Entreprises
    @PostMapping("/blockadmin/{matriculee}")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public String update(@PathVariable("matriculee") String matriculee) {
        Admin admin =adminRepository.findByMatriculee(matriculee).orElseThrow(
                () -> new IllegalArgumentException("Invalide Matricule:" + matriculee)
        );
        if(admin.getStatut().equals("Debloquer")){
            admin.setStatut("Bloquer");
            adminRepository.saveAndFlush(admin);
            return "Vous etes Bloquer";
        }
        else {
            admin.setStatut("Debloquer");
            adminRepository.saveAndFlush(admin);
            return "Vous etes Débloquer";
        }

    }

    //Methode pour bloquer les admin
    @PostMapping("/blockuser/{username}")
    @PreAuthorize("hasAuthority('ROLE_SUPERADMIN')")
    public String updated(@PathVariable("username") String username) {
        User user =userRepository.findByUsername(username).orElseThrow(
                () -> new IllegalArgumentException("Invalide Username:" + username)
        );
        if(user.getStatut().equals("Debloquer")){
            user.setStatut("Bloquer");
          userRepository.saveAndFlush(user);
            return "Vous etes Bloquer";
        }
        else {
            user.setStatut("Debloquer");
            userRepository.saveAndFlush(user);
            return "Vous etes Débloquer";
        }

    }
}