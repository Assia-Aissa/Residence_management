package com.Residence.Residence.DTO;

public class ResidentResponseDto {
    private Long id;
    private String username; // Full name (e.g., "John Doe")
    private String email;
    private String telephone;
    private String adresse;
    private String chambreNumber;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public String getChambreNumber() { return chambreNumber; }
    public void setChambreNumber(String chambreNumber) { this.chambreNumber = chambreNumber; }

    @Override
    public String toString() {
        return "ResidentResponseDto{" +
                "adresse='" + adresse + '\'' +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", chambreNumber='" + chambreNumber + '\'' +
                '}';
    }
}