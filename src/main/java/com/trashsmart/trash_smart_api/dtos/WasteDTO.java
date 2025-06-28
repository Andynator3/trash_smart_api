package com.trashsmart.trash_smart_api.dtos;

import com.trashsmart.trash_smart_api.enums.WasteType;
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
}

