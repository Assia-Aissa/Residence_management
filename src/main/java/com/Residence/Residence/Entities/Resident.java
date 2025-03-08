package com.Residence.Residence.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Resident extends User {
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;

    @OneToMany(mappedBy = "resident")
    private List<Paiement> historiquePaiements;

    @OneToMany(mappedBy = "resident")
    private List<RequeteMaintenance> historiqueRequetes;

    @OneToOne
    private Chambre chambre;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Paiement> getHistoriquePaiements() {
        return historiquePaiements;
    }

    public void setHistoriquePaiements(List<Paiement> historiquePaiements) {
        this.historiquePaiements = historiquePaiements;
    }

    public List<RequeteMaintenance> getHistoriqueRequetes() {
        return historiqueRequetes;
    }

    public void setHistoriqueRequetes(List<RequeteMaintenance> historiqueRequetes) {
        this.historiqueRequetes = historiqueRequetes;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }
}