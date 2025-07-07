package com.trashsmart.trash_smart_api.services;

import com.trashsmart.trash_smart_api.entities.TrashBin;
import com.trashsmart.trash_smart_api.repositories.TrashBinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrashBinServiceImpl implements TrashBinService {

    private final TrashBinRepository trashBinRepository;

    @Override
    public TrashBin createTrashBin(TrashBin bin) {
        return trashBinRepository.save(bin);
    }

    @Override
    public List<TrashBin> getAllTrashBins() {
        return trashBinRepository.findAll();
    }

   /* @Override
    public TrashBin updateTrashBin(Long id, TrashBin bin) {
        return null;
    }*/

  /*  @Override
    public TrashBin getTrashBinById(Long id) {
        return trashBinRepository.getTrashBinById(id);
    }*/

   /* @Override
    public void deleteTrashBin(Long id) {
        trashBinRepository.delete(getTrashBin(id));
    }*/

   /* @Override
    public List<TrashBin> searchByName(String keyword) {
        return null;
    }*/

  /*  @Override
    public List<TrashBin> getFullTrashBins() {
        return null;
    }*/

   /* @Override
    public List<TrashBin> getBlockedTrashBins() {
        return null;
    }*/

   /* @Override
    public List<TrashBin> getNearby(double lat, double lng, double maxDistanceKm) {
        return null;
    }*/
}



