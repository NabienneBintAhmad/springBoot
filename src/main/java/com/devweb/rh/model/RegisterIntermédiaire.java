package com.devweb.rh.model;

import org.springframework.format.annotation.DateTimeFormat;

public class RegisterIntermédiaire {



    private String nom;
    private String nomEntreprise;
    private String matricule;
    private int cni;
    private String ninea;
    private String adresse;
    private String email;
    private String username;
    private String password;
    private int numero;
    private int solde;
    private String contact;
    private String matriculee;
    private int cnii;
    private String adressee;
    private String emaill;
    private String nomm;
    private String prenomm;
    private String contactt;
    private String prenom;

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    private String statut;
    @DateTimeFormat(pattern ="yyyy-MM-dd-hh-mm")
    private  String date;
    private  Prestataire prestataire;
    private Admin admin;

    public User getAuthent() {
        return authent;
    }

    public void setAuthent(User authent) {
        this.authent = authent;
    }

    private User authent;


    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    private  Compte compte;




    public String getMatriculee() {
        return matriculee;
    }

    public void setMatriculee(String matriculee) {
        this.matriculee = matriculee;
    }

    public int getCnii() {
        return cnii;
    }

    public void setCnii(int cnii) {
        this.cnii = cnii;
    }

    public String getAdressee() {
        return adressee;
    }

    public void setAdressee(String adressee) {
        this.adressee = adressee;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public String getNomm() {
        return nomm;
    }

    public void setNomm(String nomm) {
        this.nomm = nomm;
    }

    public String getPrenomm() {
        return prenomm;
    }

    public void setPrenomm(String prenomm) {
        this.prenomm = prenomm;
    }

    public String getContactt() {
        return contactt;
    }

    public void setContactt(String contactt) {
        this.contactt = contactt;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getCni() {
        return cni;
    }

    public void setCni(int cni) {
        this.cni = cni;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public Long getProfil() {
        return profil;
    }

    public void setProfil(Long profil) {
        this.profil = profil;
    }

    private  Long profil;

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }



}
