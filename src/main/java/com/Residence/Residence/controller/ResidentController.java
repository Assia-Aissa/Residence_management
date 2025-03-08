package com.Residence.Residence.controller;

import com.Residence.Residence.DTO.ResidentRequestDto;
import com.Residence.Residence.DTO.ResidentResponseDto;
import com.Residence.Residence.service.ResidentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")

@RestController
@RequestMapping("/residents")
public class ResidentController {

    private final ResidentService residentService;

    public ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }

    // Create
    @PostMapping("/add")
    public ResponseEntity<ResidentResponseDto> save(@Valid @RequestBody ResidentRequestDto residentRequestDto) {
        ResidentResponseDto residentResponseDto = residentService.save(residentRequestDto);
        return new ResponseEntity<>(residentResponseDto, HttpStatus.CREATED);
    }

    // Read All
    @GetMapping("/getAllResidents")
    public ResponseEntity<List<ResidentResponseDto>> findAll() {
        List<ResidentResponseDto> residents = residentService.findAll();
        return ResponseEntity.ok(residents);
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<ResidentResponseDto> findById(@PathVariable Long id) {
        ResidentResponseDto residentResponseDto = residentService.findById(id);
        return ResponseEntity.ok(residentResponseDto);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<ResidentResponseDto> update(
            @Valid @RequestBody ResidentRequestDto residentRequestDto,
            @PathVariable Long id) {
        ResidentResponseDto residentResponseDto = residentService.update(residentRequestDto, id);
        return ResponseEntity.ok(residentResponseDto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        residentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}