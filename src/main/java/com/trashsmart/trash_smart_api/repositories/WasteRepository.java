package com.trashsmart.trash_smart_api.repositories;

import com.trashsmart.trash_smart_api.entities.Waste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WasteRepository extends JpaRepository<Waste, Long> {
    List<Waste> findByTrashBinId(Long trashBinId);
}

