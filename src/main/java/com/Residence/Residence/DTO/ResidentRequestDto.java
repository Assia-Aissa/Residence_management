package com.Residence.Residence.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ResidentRequestDto {
    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    private String username; // Full name (e.g., "John Doe")

    @NotNull(message = "Email cannot be null")
    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    private String password; // Add this field

    private String telephone;
    private String adresse;
    private String chambreNumber;

    // Getters and Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; } // Add this getter
    public void setPassword(String password) { this.password = password; } // Add this setter
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getChambreNumber() { return chambreNumber; }
    public void setChambreNumber(String chambreNumber) { this.chambreNumber = chambreNumber; }

    @Override
    public String toString() {
        return "ResidentRequestDto{" +
                "adresse='" + adresse + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", chambreNumber='" + chambreNumber + '\'' +
                ", password='" + password + '\'' + // Add this
                '}';
    }
}