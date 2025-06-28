package com.trashsmart.trash_smart_api.dtos;

import com.trashsmart.trash_smart_api.enums.WasteType;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrashBinDTO {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private WasteType type;
    private boolean full;
}

