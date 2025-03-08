package com.Residence.Residence.Repository;

import com.Residence.Residence.Entities.Resident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {
    boolean existsByEmail(String email);
    Optional<Resident> findByNomAndPrenom(String nom, String prenom);

    @Query("SELECT COUNT(r) FROM Resident r")
    long countAllResidents();
}
