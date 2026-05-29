package com.trashsmart.trash_smart_api.waste.repositories;

import com.trashsmart.trash_smart_api.waste.entities.Waste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WasteRepository extends JpaRepository<Waste, Long> {
    // Méthode métier pour le tableau de bord
    List<Waste> findByTrashcanId(Long trashcanId);
}

