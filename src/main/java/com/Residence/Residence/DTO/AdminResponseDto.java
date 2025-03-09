package com.Residence.Residence.DTO;

import com.Residence.Residence.Entities.ERole;

public class AdminResponseDto {
    private Long id;
    private String username; // Full name (e.g., "John Doe")
    private String email;
    private ERole role;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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