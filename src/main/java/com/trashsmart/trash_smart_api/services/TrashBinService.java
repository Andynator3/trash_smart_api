package com.trashsmart.trash_smart_api.services;

import com.trashsmart.trash_smart_api.entities.TrashBin;

import java.util.List;
public interface TrashBinService {
    TrashBin createTrashBin(TrashBin bin);
    List<TrashBin> getAllTrashBins();
   // TrashBin updateTrashBin(Long id, TrashBin bin);
   // TrashBin getTrashBinById(Long id);
   // void deleteTrashBin(Long id);

   // List<TrashBin> searchByName(String keyword);
   // List<TrashBin> getFullTrashBins();
   // List<TrashBin> getBlockedTrashBins();
   // List<TrashBin> getNearby(double lat, double lng, double maxDistanceKm);
}

