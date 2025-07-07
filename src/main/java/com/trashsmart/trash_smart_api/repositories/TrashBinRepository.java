package com.trashsmart.trash_smart_api.repositories;

import com.trashsmart.trash_smart_api.entities.TrashBin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrashBinRepository extends JpaRepository<TrashBin, Long> {
   // List<TrashBin> findByNameContainingIgnoreCase(String keyword);
   // List<TrashBin> findByIsFull(boolean isFull);
  //  TrashBin getTrashBinById(Long id);
  //  List<TrashBin> findByIsBlocked(boolean isBlocked);
}
