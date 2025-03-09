package com.Residence.Residence.service;

import com.Residence.Residence.DTO.RequeteMaintenanceRequestDTO;
import com.Residence.Residence.DTO.RequeteMaintenanceResponseDTO;
import com.Residence.Residence.Entities.*;
import com.Residence.Residence.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequeteMaintenanceService {

    @Autowired
    private RequeteMaintenanceRepository requeteMaintenanceRepository;

    @Autowired
    private ResidentRepository residentRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Create a new maintenance request
    public RequeteMaintenanceResponseDTO createRequeteMaintenance(RequeteMaintenanceRequestDTO requestDTO) {
        // Fetch Resident by username
        Resident resident = residentRepository.findByUsername(requestDTO.getResidentUsername())
                .orElseThrow(() -> new RuntimeException("Resident not found with username: " + requestDTO.getResidentUsername()));

        // Fetch Chambre by number
        Chambre chambre = chambreRepository.findByNumero(requestDTO.getChambreNumber())
                .orElseThrow(() -> new RuntimeException("Chambre not found"));

        // Map DTO to Entity
        RequeteMaintenance requeteMaintenance = modelMapper.map(requestDTO, RequeteMaintenance.class);
        requeteMaintenance.setResident(resident);
        requeteMaintenance.setChambre(chambre);
        requeteMaintenance.setDateSignalement(new Date());
        requeteMaintenance.setStatut(StatutRequete.EN_ATTENTE);

        // Save the entity
        RequeteMaintenance savedRequete = requeteMaintenanceRepository.save(requeteMaintenance);
        return modelMapper.map(savedRequete, RequeteMaintenanceResponseDTO.class);
    }
    // Get all maintenance requests
    public List<RequeteMaintenanceResponseDTO> getAllRequeteMaintenances() {
        List<RequeteMaintenance> requetes = requeteMaintenanceRepository.findAll();
        return requetes.stream()
                .map(requete -> modelMapper.map(requete, RequeteMaintenanceResponseDTO.class))
                .collect(Collectors.toList());
    }

    // Get a maintenance request by ID
    public RequeteMaintenanceResponseDTO getRequeteMaintenanceById(Long id) {
        Optional<RequeteMaintenance> requete = requeteMaintenanceRepository.findById(id);
        return requete.map(value -> modelMapper.map(value, RequeteMaintenanceResponseDTO.class))
                .orElseThrow(() -> new RuntimeException("RequeteMaintenance not found"));
    }

    // Update a maintenance request
    public RequeteMaintenanceResponseDTO updateRequeteMaintenance(Long id, RequeteMaintenanceRequestDTO requestDTO) {
        // Fetch the existing RequeteMaintenance by ID
        RequeteMaintenance existingRequete = requeteMaintenanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RequeteMaintenance not found"));

        // Fetch Resident by username
        Resident resident = residentRepository.findByUsername(requestDTO.getResidentUsername())
                .orElseThrow(() -> new RuntimeException("Resident not found with username: " + requestDTO.getResidentUsername()));

        // Fetch Chambre by number
        Chambre chambre = chambreRepository.findByNumero(requestDTO.getChambreNumber())
                .orElseThrow(() -> new RuntimeException("Chambre not found"));

        // Update fields
        existingRequete.setDescription(requestDTO.getDescription());
        existingRequete.setDateSignalement(requestDTO.getDateSignalement());
        existingRequete.setStatut(requestDTO.getStatut());
        existingRequete.setResident(resident);
        existingRequete.setChambre(chambre);

        // Save the updated entity
        RequeteMaintenance updatedRequete = requeteMaintenanceRepository.save(existingRequete);
        return modelMapper.map(updatedRequete, RequeteMaintenanceResponseDTO.class);
    }
    // Delete a maintenance request
    public void deleteRequeteMaintenance(Long id) {
        requeteMaintenanceRepository.deleteById(id);
    }
}