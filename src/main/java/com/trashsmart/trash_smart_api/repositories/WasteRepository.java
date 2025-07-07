package com.trashsmart.trash_smart_api.repositories;

import com.trashsmart.trash_smart_api.entities.Waste;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WasteRepository extends JpaRepository<Waste, Long> {
   // List<Waste> findByTrashBinId(Long trashBinId);
   // List<Waste> findByUser(UserTrashSmart user);
   // List<Waste> findByTrashBin(TrashBin trashBin);
   // List<Waste> findByType(WasteType type);
}

