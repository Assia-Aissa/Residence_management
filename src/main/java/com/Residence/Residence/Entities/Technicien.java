package com.Residence.Residence.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Technicien extends User {
    private String specialite;
    private String telephone;

    @OneToMany(mappedBy = "technicien")
    private List<RequeteMaintenance> requetesAssignees;

    // Getters and Setters
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
}