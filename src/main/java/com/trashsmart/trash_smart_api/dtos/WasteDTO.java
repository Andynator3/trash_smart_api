package com.trashsmart.trash_smart_api.dtos;

import com.trashsmart.trash_smart_api.entities.TrashBin;
import com.trashsmart.trash_smart_api.enums.WasteType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WasteDTO {
    private Long id;
    private double weight;
    private LocalDateTime depositedAt;
    private WasteType type;
    private Long trashBinId;
}

