package com.trashsmart.trash_smart_api.trashcan.repositories;

import com.trashsmart.trash_smart_api.trashcan.entities.TrashBin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrashBinRepository extends JpaRepository<TrashBin, Long> {
   // List<TrashBin> findByNameContainingIgnoreCase(String keyword);
   // List<TrashBin> findByIsFull(boolean isFull);
  //  TrashBin getTrashBinById(Long id);
  //  List<TrashBin> findByIsBlocked(boolean isBlocked);
}
