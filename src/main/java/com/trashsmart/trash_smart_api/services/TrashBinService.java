package com.trashsmart.trash_smart_api.services;

import com.trashsmart.trash_smart_api.entities.TrashBin;

import java.util.List;
public interface TrashBinService {
    TrashBin save(TrashBin bin);
    List<TrashBin> getAll();
    TrashBin getById(Long id);
    void delete(Long id);

    List<TrashBin> searchByName(String keyword);
    List<TrashBin> getFullTrashBins();
    List<TrashBin> getNearby(double lat, double lng, double maxDistanceKm);
}

