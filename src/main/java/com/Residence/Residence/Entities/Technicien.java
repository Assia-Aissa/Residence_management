package com.Residence.Residence.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Technicien extends User {
    private String nom;
    private String prenom;
    private String specialite;
    private String telephone;

    @OneToMany(mappedBy = "technicien")
    private List<RequeteMaintenance> requetesAssignees;

    // Getters and Setters
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

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<RequeteMaintenance> getRequetesAssignees() {
        return requetesAssignees;
    }

    public void setRequetesAssignees(List<RequeteMaintenance> requetesAssignees) {
        this.requetesAssignees = requetesAssignees;
    }

    @Override
    public String toString() {
        return "Technicien{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", specialite='" + specialite + '\'' +
                ", telephone='" + telephone + '\'' +
                ", requetesAssignees=" + requetesAssignees +
                '}';
    }
}