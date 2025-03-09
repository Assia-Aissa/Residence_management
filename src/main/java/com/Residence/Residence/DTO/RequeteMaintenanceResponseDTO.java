package com.Residence.Residence.DTO;

import com.Residence.Residence.Entities.StatutRequete;
import java.util.Date;

public class RequeteMaintenanceResponseDTO {
    private Long id;
    private String description;
    private Date dateSignalement;
    private StatutRequete statut;
    private String residentUsername;
    private String chambreNumber; // Chambre number

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getResidentUsername() {
        return residentUsername;
    }

    public void setResidentUsername(String residentUsername) {
        this.residentUsername = residentUsername;
    }

    public String getChambreNumber() {
        return chambreNumber;
    }

    public void setChambreNumber(String chambreNumber) {
        this.chambreNumber = chambreNumber;
    }
}