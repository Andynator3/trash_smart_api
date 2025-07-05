package com.trashsmart.trash_smart_api.mappers;

import com.trashsmart.trash_smart_api.dtos.WasteDTO;
import com.trashsmart.trash_smart_api.entities.TrashBin;
import com.trashsmart.trash_smart_api.entities.Waste;
import com.trashsmart.trash_smart_api.repositories.TrashBinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WasteMapper {

    private final TrashBinRepository trashBinRepository;

    public WasteDTO toDTO(Waste waste) {
        return WasteDTO.builder()
                .id(waste.getId())
                .weight(waste.getWeight())
                .depositedAt(waste.getDepositedAt())
                .type(waste.getType())
               .trashBinId(waste.getTrashBin().getId())
                .build();
    }

    public Waste fromDTO(WasteDTO dto) {
       TrashBin bin = trashBinRepository.findById(dto.getTrashBinId())
               .orElseThrow(() -> new RuntimeException("Trash bin not found"));
        return Waste.builder()
                .id(dto.getId())
                .weight(dto.getWeight())
                .depositedAt(dto.getDepositedAt())
                .type(dto.getType())
                .trashBin(bin)
                .build();
    }
}

