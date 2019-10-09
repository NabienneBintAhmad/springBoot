package com.devweb.rh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username"
        })

})
public class User{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private   String statut;
    private  String username;
    private  String password;
    @JoinColumn(name = "presta_id",referencedColumnName ="id",nullable = true)
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("admins")
    private Prestataire prestataire;
    @JoinColumn(name = "admin_id",referencedColumnName ="id",nullable = true)
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("prestataires")
    private Admin admin;

    public UserPrestataire getUserPrestataire() {
        return userPrestataire;
    }

    public void setUserPrestataire(UserPrestataire userPrestataire) {
        this.userPrestataire = userPrestataire;
    }

    @JoinColumn(name = "userpresta_id",referencedColumnName ="id",nullable = true)
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("userPrestataires")
    private UserPrestataire userPrestataire;
    public Caissier getCaissier() {
        return caissier;
    }

    public void setCaissier(Caissier caissier) {
        this.caissier = caissier;
    }

    @JoinColumn(name = "caissier_id",referencedColumnName ="id", nullable = true)
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("depots")
    private Caissier caissier;


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {}



    public User(String username, String password, String statut) {

        this.username = username;
        this.password = password;
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public void setUsername(String username) {
        this.username = username;
    }



    public  String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public  String getUsername() {
        return username;
    }

    public  String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Prestataire getPrestataire() {
        return prestataire;
    }

    public void setPrestataire(Prestataire prestataire) {
        this.prestataire = prestataire;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }


}