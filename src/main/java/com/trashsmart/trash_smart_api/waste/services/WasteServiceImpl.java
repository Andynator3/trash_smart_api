package com.trashsmart.trash_smart_api.waste.services;

import com.trashsmart.trash_smart_api.waste.services.WasteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WasteServiceImpl implements WasteService {

  //  private final WasteRepository wasteRepository;
  //  private final TrashBinRepository trashBinRepository;

   /* @Override
    public Waste saveWaste(Waste waste, Long trashBinId) {
        TrashBin trashBin = trashBinRepository.findById(trashBinId)
                .orElseThrow(() -> new RuntimeException("Trash bin not found"));
        waste.setTrashBin(trashBin);
        waste.setDepositedAt(LocalDateTime.now());
        return wasteRepository.save(waste);
    }*/

    /*@Override
    public List<Waste> getAllWastes() {
        return wasteRepository.findAll();
    }*/

   /* @Override
    public List<Waste> getWastesByTrashBin(Long trashBinId) {
        return wasteRepository.findByTrashBinId(trashBinId);
    }*/
}

