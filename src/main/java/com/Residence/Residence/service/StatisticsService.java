package com.Residence.Residence.service;


import com.Residence.Residence.Entities.StatutChambre;
import com.Residence.Residence.Repository.ChambreRepository;
import com.Residence.Residence.Repository.ResidentRepository;
import com.Residence.Residence.Repository.TechnicienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
    public class StatisticsService {

        @Autowired
        private ChambreRepository chambreRepository;

        @Autowired
        private ResidentRepository residentRepository;

        @Autowired
        private TechnicienRepository technicienRepository;

        // Total number of chambres
        public long getTotalChambres() {
            return chambreRepository.countAllChambres();
        }

        // Number of available chambres
        public long getAvailableChambres() {
            return chambreRepository.countChambresByStatut(StatutChambre.DISPONIBLE);
        }

        // Number of occupied chambres
        public long getOccupiedChambres() {
            return chambreRepository.countChambresByStatut(StatutChambre.OCCUPEE);
        }

        // Number of chambres under maintenance
        public long getMaintenanceChambres() {
            return chambreRepository.countChambresByStatut(StatutChambre.EN_MAINTENANCE);
        }

        // Total number of residents
        public long getTotalResidents() {
            return residentRepository.countAllResidents();
        }

        // Total number of technicians
        public long getTotalTechniciens() {
            return technicienRepository.countAllTechniciens();
        }
    }

