package com.trashsmart.trash_smart_api.mappers;

import com.trashsmart.trash_smart_api.dtos.TrashBinDTO;
import com.trashsmart.trash_smart_api.entities.TrashBin;
import org.springframework.stereotype.Component;

@Component
public class TrashBinMapper {

    public TrashBinDTO toDTO(TrashBin bin) {
        return TrashBinDTO.builder()
                .id(bin.getId())
                .name(bin.getName())
                .latitude(bin.getLatitude())
                .longitude(bin.getLongitude())
                .full(bin.isFull())
                .build();
    }

    public TrashBin fromDTO(TrashBinDTO dto) {
        return TrashBin.builder()
                .id(dto.getId())
                .name(dto.getName())
                .latitude(dto.getLatitude())
                .longitude(dto.getLongitude())
                .full(dto.isFull())
                .build();
    }
}

