package com.Residence.Residence.Entities;

import jakarta.persistence.*;

@Entity
public class Administrateur extends User {
    private String nom;
    private String prenom;

    @Enumerated(EnumType.STRING)
    private ERole role;

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

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}