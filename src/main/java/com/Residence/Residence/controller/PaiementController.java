package com.Residence.Residence.controller;

import com.Residence.Residence.DTO.PaiementRequestDto;
import com.Residence.Residence.DTO.PaiementResponseDto;
import com.Residence.Residence.service.PaiementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/paiements")
public class PaiementController {

    @Autowired
    private PaiementService paiementService;

    @PostMapping
    public ResponseEntity<?> createPaiement(@Valid @RequestBody PaiementRequestDto requestDTO) {
        try {
            PaiementResponseDto responseDTO = paiementService.save(requestDTO);
            return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error creating payment: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<PaiementResponseDto>> findAll() {
        List<PaiementResponseDto> paiements = paiementService.findAll();
        return ResponseEntity.ok(paiements);
    }

    @GetMapping("/resident/{residentId}")
    public ResponseEntity<List<PaiementResponseDto>> getPaiementsByResidentId(@PathVariable Long residentId) {
        List<PaiementResponseDto> paiements = paiementService.getPaiementsByResidentId(residentId);
        return new ResponseEntity<>(paiements, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaiementResponseDto> findById(@PathVariable Long id) {
        PaiementResponseDto paiementResponseDto = paiementService.findById(id);
        return ResponseEntity.ok(paiementResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaiementResponseDto> update(
            @Valid @RequestBody PaiementRequestDto paiementRequestDto,
            @PathVariable Long id) {
        PaiementResponseDto paiementResponseDto = paiementService.update(paiementRequestDto, id);
        return ResponseEntity.ok(paiementResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paiementService.delete(id);
        return ResponseEntity.noContent().build();
    }
}