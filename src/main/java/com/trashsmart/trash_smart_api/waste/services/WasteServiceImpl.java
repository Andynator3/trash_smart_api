package com.trashsmart.trash_smart_api.waste.services;

import com.trashsmart.trash_smart_api.trashcan.entities.Trashcan;
import com.trashsmart.trash_smart_api.trashcan.repositories.TrashcanRepository;
import com.trashsmart.trash_smart_api.waste.dtos.WasteDto;
import com.trashsmart.trash_smart_api.waste.entities.Waste;
import com.trashsmart.trash_smart_api.waste.mappers.WasteMapper;
import com.trashsmart.trash_smart_api.waste.repositories.WasteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WasteServiceImpl implements WasteService {

    private final WasteRepository wasteRepository;
    private final TrashcanRepository trashcanRepository;
    private final WasteMapper wasteMapper;

    @Override
    public WasteDto addWaste(WasteDto wasteDto) {
        Trashcan trashcan = null;
        if (wasteDto.getTrashcanId() != null) {
            trashcan = trashcanRepository.findById(wasteDto.getTrashcanId())
                    .orElseThrow(() -> new RuntimeException("Poubelle non trouvée"));
        }

        Waste waste = wasteMapper.toEntity(wasteDto, trashcan);
        Waste savedWaste = wasteRepository.save(waste);
        return wasteMapper.toDto(savedWaste);
    }

    @Override
    public WasteDto getWasteById(Long id) {
        Waste waste = wasteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Déchet introuvable avec l'ID : " + id));
        return wasteMapper.toDto(waste); // Adapte avec le nom de ta méthode de mapping
    }
    @Override
    public List<WasteDto> getAllWastes() {
        return wasteRepository.findAll().stream()
                .map(wasteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public WasteDto updateWaste(Long id, WasteDto wasteDto) {
        Waste existingWaste = wasteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Déchet introuvable avec l'ID : " + id));

        // Mise à jour des champs modifiables
        existingWaste.setWasteType(wasteDto.getWasteType());
        existingWaste.setWeight(wasteDto.getWeight());
        existingWaste.setVolume(wasteDto.getVolume());

        Waste updatedWaste = wasteRepository.save(existingWaste);
        return wasteMapper.toDto(updatedWaste);
    }

    @Override
    public void deleteWaste(Long id) {
        if (!wasteRepository.existsById(id)) {
            throw new RuntimeException("Déchet introuvable avec l'ID : " + id);
        }
        wasteRepository.deleteById(id);
    }

    @Override
    public List<WasteDto> getWastesByTrashcanId(Long trashcanId) {
        return wasteRepository.findByTrashcanId(trashcanId).stream()
                .map(wasteMapper::toDto)
                .collect(Collectors.toList());
    }
}

