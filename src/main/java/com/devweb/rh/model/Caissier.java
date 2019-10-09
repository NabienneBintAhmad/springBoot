package com.devweb.rh.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@EqualsAndHashCode(exclude = "prestataire")
public class Caissier
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10)
    private String matriculee;
    @Column(length = 50)
    private String nomm;
    @Column(length = 50)
    private String prenomm;
    @Column(length = 50)
    private String adressee;
    @Column(length = 15)
    private String contactt;
    @NotBlank
    @Size(max = 50)
    @Email
    private String emaill;
    private int cnii;
  /*  @JoinColumn(name = "presta_id",referencedColumnName ="id")
    @ManyToOne(optional = false)
    @JsonIgnoreProperties("admins")
    private Prestataire prestataire;*/

    public String getPrenomm() {
        return prenomm;
    }

    public void setPrenomm(String prenomm) {
        this.prenomm = prenomm;
    }

    public String getAdressee() {
        return adressee;
    }

    public void setAdressee(String adressee) {
        this.adressee = adressee;
    }

    public String getContactt() {
        return contactt;
    }

    public void setContactt(String contactt) {
        this.contactt = contactt;
    }

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public int getCnii() {
        return cnii;
    }

    public void setCnii(int cnii) {
        this.cnii = cnii;
    }

    public Caissier(String matriculee, String nom, String prenomm, String adressee, String contactt, String emaill, int cnii) {
        this.matriculee = matriculee;
        this.nomm = nom;
        this.prenomm = prenomm;
        this.adressee = adressee;
        this.contactt = contactt;
        this.emaill = emaill;
        this.cnii = cnii;

    }

    public Caissier() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatriculee() {
        return matriculee;
    }

    public void setMatriculee(String matriculee) {
        this.matriculee = matriculee;
    }

    public String getNomm() {
        return nomm;
    }

    public void setNomm(String nomm) {
        this.nomm = nomm;
    }




}
