package com.devweb.rh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "prestataire")
public class Depot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "caissier",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("caissiers")
    private Caissier caissier;
    @JoinColumn(name = "compte",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("comptes")
    private Compte compte;
    private int montant;
    @DateTimeFormat(pattern ="yyyy-MM-dd-hh-mm")
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Caissier getCaissier() {
        return caissier;
    }

    public void setCaissier(Caissier caissier) {
        this.caissier = caissier;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
