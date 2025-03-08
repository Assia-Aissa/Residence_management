package com.Residence.Residence.Repository;

import com.Residence.Residence.Entities.Chambre;
import com.Residence.Residence.Entities.StatutChambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Optional<Chambre> findByNumero(String numero);

    List<Chambre> findByStatut(StatutChambre statut); // Find chambres by status

    @Query("SELECT COUNT(c) FROM Chambre c")
    long countAllChambres();

    @Query("SELECT COUNT(c) FROM Chambre c WHERE c.statut = :statut")
    long countChambresByStatut(StatutChambre statut);
}