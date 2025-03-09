package com.Residence.Residence.DTO;

import com.Residence.Residence.Entities.StatutPaiement;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Date;

public class PaiementRequestDto {
    @Positive(message = "Amount paid must be positive")
    private double montantPaye; // Amount paid by the resident

    @NotNull(message = "Payment status is required")
    private StatutPaiement statut; // Payment status

    @NotNull(message = "Payment date is required")
    private Date datePaiement; // Payment date

    @NotBlank(message = "Resident name is required")
    private String residentUsername; // Resident's last name



    // Getters and Setters
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

    public @NotBlank(message = "Resident name is required") String getResidentUsername() {
        return residentUsername;
    }

    public void setResidentUsername(@NotBlank(message = "Resident name is required") String residentUsername) {
        this.residentUsername = residentUsername;
    }
}