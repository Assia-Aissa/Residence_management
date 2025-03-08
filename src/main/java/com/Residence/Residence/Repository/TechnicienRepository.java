package com.Residence.Residence.Repository;

import com.Residence.Residence.Entities.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicienRepository extends JpaRepository<Technicien, Long> {

    @Query("SELECT COUNT(t) FROM Technicien t")
    long countAllTechniciens();
}
