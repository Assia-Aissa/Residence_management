package com.Residence.Residence.controller;

import com.Residence.Residence.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    // Get total number of chambres
    @GetMapping("/chambres/total")
    public ResponseEntity<Long> getTotalChambres() {
        return ResponseEntity.ok(statisticsService.getTotalChambres());
    }

    // Get number of available chambres
    @GetMapping("/chambres/available")
    public ResponseEntity<Long> getAvailableChambres() {
        return ResponseEntity.ok(statisticsService.getAvailableChambres());
    }

    // Get number of occupied chambres
    @GetMapping("/chambres/occupied")
    public ResponseEntity<Long> getOccupiedChambres() {
        return ResponseEntity.ok(statisticsService.getOccupiedChambres());
    }

    // Get number of chambres under maintenance
    @GetMapping("/chambres/maintenance")
    public ResponseEntity<Long> getMaintenanceChambres() {
        return ResponseEntity.ok(statisticsService.getMaintenanceChambres());
    }

    // Get total number of residents
    @GetMapping("/residents/total")
    public ResponseEntity<Long> getTotalResidents() {
        return ResponseEntity.ok(statisticsService.getTotalResidents());
    }

    // Get total number of technicians
    @GetMapping("/techniciens/total")
    public ResponseEntity<Long> getTotalTechniciens() {
        return ResponseEntity.ok(statisticsService.getTotalTechniciens());
    }
}