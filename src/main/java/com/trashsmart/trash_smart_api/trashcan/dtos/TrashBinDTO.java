package com.trashsmart.trash_smart_api.trashcan.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrashBinDTO {
    private Long id;
    private String locationName;
    private double latitude;
    private double longitude;
    private boolean isFull;
    private boolean isBlocked;
}

