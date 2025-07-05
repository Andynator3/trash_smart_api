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
    public TrashBin save(TrashBin bin) {
        return trashBinRepository.save(bin);
    }

    @Override
    public List<TrashBin> getAll() {
        return trashBinRepository.findAll();
    }

    @Override
    public TrashBin getById(Long id) {
        return trashBinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trash bin not found"));
    }

    @Override
    public void delete(Long id) {
        trashBinRepository.deleteById(id);
    }

    @Override
    public List<TrashBin> searchByName(String keyword) {
        return null;
    }

    @Override
    public List<TrashBin> getFullTrashBins() {
        return null;
    }

    public List<TrashBin> getNearby(double userLat, double userLng, double maxDistanceKm) {
        return trashBinRepository.findAll().stream()
                .filter(bin -> distanceInKm(userLat, userLng, bin.getLatitude(), bin.getLongitude()) <= maxDistanceKm)
                .toList();
    }

    private double distanceInKm(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371; // Rayon de la Terre en km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon/2) * Math.sin(dLon/2);
        return R * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }
}



