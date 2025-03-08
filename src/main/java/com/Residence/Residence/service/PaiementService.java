package com.Residence.Residence.service;

import com.Residence.Residence.DTO.PaiementRequestDto;
import com.Residence.Residence.DTO.PaiementResponseDto;
import com.Residence.Residence.Entities.Paiement;
import com.Residence.Residence.Entities.Resident;
import com.Residence.Residence.Repository.PaiementRepository;
import com.Residence.Residence.Repository.ResidentRepository;
import com.itextpdf.text.DocumentException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaiementService {
    private final PaiementRepository paiementRepository;
    private final ResidentRepository residentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    private PdfService pdfService;

    public PaiementService(PaiementRepository paiementRepository, ResidentRepository residentRepository, ModelMapper modelMapper) {
        this.paiementRepository = paiementRepository;
        this.residentRepository = residentRepository;
        this.modelMapper = modelMapper;
    }

    public PaiementResponseDto save(PaiementRequestDto requestDTO) {
        // Find the resident by nom and prenom
        Resident resident = residentRepository.findByNomAndPrenom(requestDTO.getResidentNom(), requestDTO.getResidentPrenom())
                .orElseThrow(() -> new RuntimeException("Resident not found"));

        // Create and save the payment
        Paiement paiement = new Paiement();
        paiement.setMontantPaye(requestDTO.getMontantPaye());
        paiement.setStatut(requestDTO.getStatut());
        paiement.setDatePaiement(requestDTO.getDatePaiement());
        paiement.setResident(resident);
        System.out.println("--------------->"+paiement);

        Paiement savedPaiement = paiementRepository.save(paiement);
        System.out.println("--------------->"+savedPaiement);
        return mapToResponseDto(savedPaiement);
    }
    public byte[] getRecu(Long id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement not found"));
        return paiement.getRecu();
    }

    private PaiementResponseDto mapToResponseDto(Paiement paiement) {
        PaiementResponseDto responseDTO = new PaiementResponseDto();
        responseDTO.setId(paiement.getId());
        responseDTO.setMontantPaye(paiement.getMontantPaye());
        responseDTO.setStatut(paiement.getStatut());
        responseDTO.setDatePaiement(paiement.getDatePaiement());
        responseDTO.setRecuUrl("/paiements/" + paiement.getId() + "/recu");
        responseDTO.setResidentId(paiement.getResident().getId());
        responseDTO.setResidentNom(paiement.getResident().getNom());
        responseDTO.setResidentPrenom(paiement.getResident().getPrenom());
        return responseDTO;
    }

    public List<PaiementResponseDto> getPaiementsByResidentId(Long residentId) {
        return paiementRepository.findByResidentId(residentId).stream()
                .map(paiement -> modelMapper.map(paiement, PaiementResponseDto.class))
                .collect(Collectors.toList());
    }

    public List<PaiementResponseDto> findAll() {
        return paiementRepository.findAll().stream()
                .map(paiement -> modelMapper.map(paiement, PaiementResponseDto.class))
                .collect(Collectors.toList());
    }

    public PaiementResponseDto findById(Long id) {
        Paiement paiement = paiementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paiement not found"));
        return modelMapper.map(paiement, PaiementResponseDto.class);
    }

    public PaiementResponseDto update(PaiementRequestDto paiementRequestDto, Long id) {
        Optional<Paiement> paiementOptional = paiementRepository.findById(id);
        if (paiementOptional.isPresent()) {
            Paiement paiement = paiementOptional.get();
            modelMapper.map(paiementRequestDto, paiement);

            // Find the resident by nom and prenom
            Resident resident = residentRepository.findByNomAndPrenom(paiementRequestDto.getResidentNom(), paiementRequestDto.getResidentPrenom())
                    .orElseThrow(() -> new RuntimeException("Resident not found"));
            paiement.setResident(resident);

            Paiement updated = paiementRepository.save(paiement);
            return modelMapper.map(updated, PaiementResponseDto.class);
        } else {
            throw new RuntimeException("Paiement not found");
        }
    }
    public void delete(Long id) {
        paiementRepository.deleteById(id);
    }
}