package com.devweb.rh.controller;

import com.devweb.rh.model.Role;
import com.devweb.rh.model.User;
import com.devweb.rh.model.UserIntermediaire;
import com.devweb.rh.repository.UserRepository;
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
@RequestMapping(value = "/user")
public class UserController {



    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @GetMapping(value = "/liste")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> liste(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User add(@RequestBody(required = false) UserIntermediaire userIntermediaire){
        User u = new User();
        u.setUsername(userIntermediaire.getUsername());
        u.setPassword(encoder.encode(userIntermediaire.getPassword()));
        u.setStatut("Debloquer");
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        role.setId(userIntermediaire.getProfil());
        roles.add(role);
        u.setRoles(roles);
        return userRepository.save(u);
    }
}
