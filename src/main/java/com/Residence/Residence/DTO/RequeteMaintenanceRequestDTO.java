package com.Residence.Residence.DTO;

import com.Residence.Residence.Entities.StatutRequete;
import java.util.Date;

public class RequeteMaintenanceRequestDTO {
    private String description;
    private Date dateSignalement;
    private StatutRequete statut;
    private String residentNom; // Resident's last name
    private String residentPrenom; // Resident's first name
    private String chambreNumber; // Chambre number

    // Getters and Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateSignalement() {
        return dateSignalement;
    }

    public void setDateSignalement(Date dateSignalement) {
        this.dateSignalement = dateSignalement;
    }

    public StatutRequete getStatut() {
        return statut;
    }

    public void setStatut(StatutRequete statut) {
        this.statut = statut;
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

    public String getChambreNumber() {
        return chambreNumber;
    }

    public void setChambreNumber(String chambreNumber) {
        this.chambreNumber = chambreNumber;
    }
}