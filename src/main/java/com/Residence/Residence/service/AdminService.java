package com.Residence.Residence.service;

import com.Residence.Residence.DTO.AdminRequestDto;
import com.Residence.Residence.DTO.AdminResponseDto;
import com.Residence.Residence.Entities.Administrateur;
import com.Residence.Residence.Repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder; // Inject PasswordEncoder

    @Autowired
    public AdminService(AdminRepository adminRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder; // Initialize PasswordEncoder
    }

    // Create
    public AdminResponseDto save(AdminRequestDto adminRequestDto) {
        // Map AdminRequestDto to Administrateur entity
        Administrateur administrateur = modelMapper.map(adminRequestDto, Administrateur.class);
        administrateur.setRole(adminRequestDto.getRole()); // Set the role explicitly

        // Encode the password before saving
        administrateur.setPassword(passwordEncoder.encode(adminRequestDto.getPassword()));

        // Save the administrateur
        Administrateur saved = adminRepository.save(administrateur);

        // Map the saved entity to AdminResponseDto
        return modelMapper.map(saved, AdminResponseDto.class);
    }

    // Read All
    public List<AdminResponseDto> findAll() {
        return adminRepository.findAll().stream()
                .map(admin -> modelMapper.map(admin, AdminResponseDto.class))
                .collect(Collectors.toList());
    }

    // Read by ID
    public AdminResponseDto findById(Long id) {
        Administrateur administrateur = adminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Administrateur not found"));
        return modelMapper.map(administrateur, AdminResponseDto.class);
    }

    // Update
    public AdminResponseDto update(AdminRequestDto adminRequestDto, Long id) {
        Optional<Administrateur> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) {
            Administrateur administrateur = adminOptional.get();
            modelMapper.map(adminRequestDto, administrateur);
            administrateur.setId(id);
            administrateur.setRole(adminRequestDto.getRole()); // Set the role explicitly

            // Encode the password before updating
            administrateur.setPassword(passwordEncoder.encode(adminRequestDto.getPassword()));

            Administrateur updated = adminRepository.save(administrateur);
            return modelMapper.map(updated, AdminResponseDto.class);
        } else {
            throw new RuntimeException("Administrateur not found");
        }
    }

    // Delete
    public void delete(Long id) {
        adminRepository.deleteById(id);
    }
}