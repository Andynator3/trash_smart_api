package com.trashsmart.trash_smart_api.dtos;

import com.trashsmart.trash_smart_api.entities.Waste;
import com.trashsmart.trash_smart_api.enums.WasteType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrashBinDTO {
    private Long id;
    private String name;
    private double latitude;
    private double longitude;
    private boolean full;
}

