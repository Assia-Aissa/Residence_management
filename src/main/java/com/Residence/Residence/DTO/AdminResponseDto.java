package com.Residence.Residence.DTO;

import com.Residence.Residence.Entities.ERole;

public class AdminResponseDto {

        private Long id;
        private String nom;
        private String prenom;
        private String email;
        private ERole role;

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public ERole getRole() {
            return role;
        }

        public void setRole(ERole role) {
            this.role = role;
        }

}
