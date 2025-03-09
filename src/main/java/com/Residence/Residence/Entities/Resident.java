package com.Residence.Residence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Resident extends User {
    private String telephone;
    private String adresse;

    @OneToMany(mappedBy = "resident")
    private List<Paiement> historiquePaiements;

    @OneToMany(mappedBy = "resident")
    private List<RequeteMaintenance> historiqueRequetes;

    @OneToOne
    private Chambre chambre;

    // Getters and Setters
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

    @Override
    public String toString() {
        return "Resident{" +
                "adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", historiquePaiements=" + historiquePaiements +
                ", historiqueRequetes=" + historiqueRequetes +
                ", chambre=" + chambre +
                '}';
    }
}