package com.trashsmart.trash_smart_api.waste.dtos;

import com.trashsmart.trash_smart_api.core.enums.WasteType;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WasteDTO {
    private Long id;
    private String description;
    private double weight;
    private LocalDateTime depositedAt;
    private WasteType type;
    private Long trashBinId;
    private Long userTrashSmartId;
}

