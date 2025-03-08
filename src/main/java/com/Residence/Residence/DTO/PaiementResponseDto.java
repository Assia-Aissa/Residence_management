package com.Residence.Residence.DTO;

import com.Residence.Residence.Entities.StatutPaiement;

import java.util.Date;

public class PaiementResponseDto {

    private Long id;
    private double montantPaye;
    private StatutPaiement statut;
    private Date datePaiement;
    private String recu;
    private String recuUrl; // Add this field
    private Long residentId;
    private String residentNom;
    private String residentPrenom;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public StatutPaiement getStatut() {
        return statut;
    }

    public void setStatut(StatutPaiement statut) {
        this.statut = statut;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getRecu() {
        return recu;
    }

    public void setRecu(String recu) {
        this.recu = recu;
    }

    public String getRecuUrl() {
        return recuUrl;
    }

    public void setRecuUrl(String recuUrl) {
        this.recuUrl = recuUrl;
    }

    public Long getResidentId() {
        return residentId;
    }

    public void setResidentId(Long residentId) {
        this.residentId = residentId;
    }

    public String getResidentNom() {
        return residentNom;
    }


    public void setResidentNom(String residentNom) {
        this.residentNom = residentNom;
    }

    public String getResidentPrenom() {
        return residentPrenom;
    }

    public void setResidentPrenom(String residentPrenom) {
        this.residentPrenom = residentPrenom;
    }
}