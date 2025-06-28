package com.trashsmart.trash_smart_api.services;

import com.trashsmart.trash_smart_api.entities.TrashBin;
import com.trashsmart.trash_smart_api.entities.Waste;
import com.trashsmart.trash_smart_api.repositories.TrashBinRepository;
import com.trashsmart.trash_smart_api.repositories.WasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WasteServiceImpl implements WasteService {

    private final WasteRepository wasteRepository;
    private final TrashBinRepository trashBinRepository;

    @Override
    public Waste saveWaste(Waste waste, Long trashBinId) {
        TrashBin trashBin = trashBinRepository.findById(trashBinId)
                .orElseThrow(() -> new RuntimeException("Trash bin not found"));
        waste.setTrashBin(trashBin);
        waste.setDepositedAt(LocalDateTime.now());
        return wasteRepository.save(waste);
    }

    @Override
    public List<Waste> getAllWastes() {
        return wasteRepository.findAll();
    }

    @Override
    public List<Waste> getWastesByTrashBin(Long trashBinId) {
        return wasteRepository.findByTrashBinId(trashBinId);
    }
}

