package com.devweb.rh.services;

import com.devweb.rh.model.Admin;
import com.devweb.rh.model.Caissier;
import com.devweb.rh.model.Prestataire;
import com.devweb.rh.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String statut;

    public Caissier getCaissier() {
        return caissier;
    }

    public Prestataire getPrestataire() {
        return prestataire;
    }

    public Admin getAdmin() {
        return admin;
    }

    private Caissier caissier;
    private Prestataire prestataire;
    private Admin admin;
    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrinciple(Long id,
                         String username, String statut, String password,Admin admin,Prestataire prestataire,Caissier caissier,
                         Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.statut = statut;
        this.password = password;
        this.admin = admin;
        this.caissier = caissier;
        this.prestataire = prestataire;
        this.authorities = authorities;
    }



    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(role ->
                new SimpleGrantedAuthority(role.getName().name())
        ).collect(Collectors.toList());

        return new UserPrinciple(
                user.getId(),
                user.getUsername(),
                user.getStatut(),
                user.getPassword(),
                user.getAdmin(),
                user.getPrestataire(),
                user.getCaissier(),
                authorities
        );
    }

    public Long getId() {
        return id;
    }


    public String getStatut() {
        return statut;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}
