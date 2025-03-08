package com.Residence.Residence.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String numero;

    private Double taille;
    private String equipements;

    @Enumerated(EnumType.STRING)
    private StatutChambre statut = StatutChambre.DISPONIBLE;

    @OneToOne(mappedBy = "chambre")
    private Resident resident;

    @Override
    public String toString() {
        return "Chambre{" +
                "id=" + id +
                ", equipements='" + equipements + '\'' +
                ", numero='" + numero + '\'' +
                ", statut='" + statut + '\'' +
                ", taille=" + taille +
                '}';
    }

    public StatutChambre getStatut() {
        return statut;
    }

    public void setStatut(StatutChambre statut) {
        this.statut = statut;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Double getTaille() {
        return taille;
    }

    public void setTaille(Double taille) {
        this.taille = taille;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipements() {
        return equipements;
    }

    public void setEquipements(String equipements) {
        this.equipements = equipements;
    }
}