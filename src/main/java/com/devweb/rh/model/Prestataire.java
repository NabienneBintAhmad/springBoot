package com.devweb.rh.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity

@Data
@EqualsAndHashCode(exclude = "admins")
public class Prestataire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30)
    private String nom;
    @Column(length = 30)
    private String prenom;
    @Column(length = 100)
    private String NomEntreprise;
    @Column(length = 10)
    private String matricule;
    @Column(length = 50)
    private int cni;
    @Column(length = 50)
    private String ninea;
    @Column(length = 50)
    private String adresse;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String contact;
    @Column(length = 15)
    private int compte;




/*


    @OneToMany(mappedBy ="prestataire", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("prestataire")
    private List <Compte> comptes;

    @OneToMany(mappedBy ="prestataire", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonIgnoreProperties("prestataire")
    private List <User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
*/


    public Prestataire() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEntreprise() {
        return NomEntreprise;
    }

    public void setNomEntreprise(String NomEntreprise) {
        this.NomEntreprise = NomEntreprise;
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getNom() { return nom; }

    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }

    public void setPrenom(String prenom) { this.prenom = prenom; }
public  int getCompte() {return compte; }

    public void setCompte(int compte) {
        this.compte = compte;
    }
}
