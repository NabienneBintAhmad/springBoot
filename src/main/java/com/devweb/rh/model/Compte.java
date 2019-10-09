package com.devweb.rh.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity

@Data
public class Compte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero;
    private int solde;

    @DateTimeFormat(pattern ="yyyy-MM-dd-hh-mm")
    private String date;
    @JoinColumn(name = "presta_id",referencedColumnName ="id",nullable = false)
    @ManyToOne(optional = true, fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("compte")
    private Prestataire prestataire;
    public Compte(int numero, int solde, String date, Prestataire prestataire) {
        this.numero = numero;
        this.solde = solde;
        this.date = date;
        this.prestataire = prestataire;
    }

    public Compte() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getDate(String mat) {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Prestataire getPrestataire(Prestataire prestataire) {
        return this.prestataire;
    }

    public void setPrestataire(Prestataire prestataire) {
        this.prestataire = prestataire;
    }


    }

