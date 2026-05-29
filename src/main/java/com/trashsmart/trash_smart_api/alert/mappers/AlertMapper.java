package com.trashsmart.trash_smart_api.alert.mappers;

import com.trashsmart.trash_smart_api.alert.dtos.AlertDto;
import com.trashsmart.trash_smart_api.alert.entites.Alert;
import com.trashsmart.trash_smart_api.trashcan.entities.Trashcan;
import org.springframework.stereotype.Component;

@Component
public class AlertMapper {

    public AlertDto toDto(Alert alert) {
        if (alert == null) return null;
        return AlertDto.builder()
                .id(alert.getId())
                .severity(alert.getSeverity())
                .description(alert.getDescription())
                .createdAt(alert.getCreatedAt())
                .isAcknowledged(alert.isAcknowledged())
                .trashcanId(alert.getTrashcan() != null ? alert.getTrashcan().getId() : null)
                .trashcanReference(alert.getTrashcan() != null ? alert.getTrashcan().getReference() : null)
                .build();
    }

    public Alert toEntity(AlertDto dto, Trashcan trashcan) {
        if (dto == null) return null;
        return Alert.builder()
                .id(dto.getId())
                .severity(dto.getSeverity())
                .description(dto.getDescription())
                .createdAt(dto.getCreatedAt() != null ? dto.getCreatedAt() : java.time.LocalDateTime.now())
                .isAcknowledged(dto.isAcknowledged())
                .trashcan(trashcan)
                .build();
    }
}
