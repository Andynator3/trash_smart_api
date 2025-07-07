package com.trashsmart.trash_smart_api.mappers;

import com.trashsmart.trash_smart_api.dtos.TrashBinDTO;
import com.trashsmart.trash_smart_api.entities.TrashBin;
import org.springframework.stereotype.Component;

@Component
public class TrashBinMapper {

    public TrashBinDTO toDTO(TrashBin bin) {
        return TrashBinDTO.builder()
                .id(bin.getId())
                .locationName(bin.getLocationName())
                .latitude(bin.getLatitude())
                .longitude(bin.getLongitude())
                .isFull(bin.isFull())
                .isBlocked(bin.isBlocked())
                .build();
    }

    public TrashBin fromDTO(TrashBinDTO dto) {
        return TrashBin.builder()
                .id(dto.getId())
                .locationName(dto.getLocationName())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .isFull(dto.isFull())
                .isBlocked(dto.isBlocked())
                .build();
    }
}

