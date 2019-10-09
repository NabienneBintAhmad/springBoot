package com.devweb.rh.controller;

import com.devweb.rh.model.RegisterIntermédiaire;
import com.devweb.rh.model.Role;
import com.devweb.rh.model.User;
import com.devweb.rh.model.UserPrestataire;
import com.devweb.rh.repository.UserRepository;
import com.devweb.rh.repository.UserprestataireRepository;
import com.devweb.rh.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class UserPrestataireController {
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private UserprestataireRepository userprestataireRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @GetMapping(value = "/listuserpresta")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserPrestataire> liste(){
        return userprestataireRepository.findAll();
    }
    @PostMapping(value = "/users",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public UserPrestataire add(@RequestBody(required = false) RegisterIntermédiaire registerIntermédiaire){
        UserPrestataire a = new UserPrestataire();
        a.setNomm(registerIntermédiaire.getNomm());
        a.setPrenomm(registerIntermédiaire.getPrenomm());
        a.setMatriculee(registerIntermédiaire.getMatriculee());
        a.setCnii(registerIntermédiaire.getCnii());
        a.setAdressee(registerIntermédiaire.getAdressee());
        a.setEmaill(registerIntermédiaire.getEmaill());
        a.setContactt(registerIntermédiaire.getContactt());
        User user = userDetailsService.getCeluiConnnecter();
        a.setAdmin(user.getAdmin());
       userprestataireRepository.save(a);

        User u =new User();

        u.setUsername(registerIntermédiaire.getUsername());

        u.setStatut("Debloquer");
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId((long) 2);
        roles.add(role);
        u.setRoles(roles);
        u.setAdmin(user.getAdmin());
        u.setPassword(encoder.encode(registerIntermédiaire.getPassword()));
        userRepository.save(u);
        return  userprestataireRepository.save(a);
    }

}
