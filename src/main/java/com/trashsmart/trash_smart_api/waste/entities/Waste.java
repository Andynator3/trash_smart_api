package com.trashsmart.trash_smart_api.waste.entities;

import com.trashsmart.trash_smart_api.core.enums.WasteType;
import com.trashsmart.trash_smart_api.trashcan.entities.TrashBin;
import com.trashsmart.trash_smart_api.trashcan.entities.UserTrashSmart;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Waste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double weight;

    private LocalDateTime depositedAt;

    @Enumerated(EnumType.STRING)
    private WasteType type;

    @ManyToOne
    @JoinColumn(name = "trashBin")
    private TrashBin trashBin;

    @ManyToOne
    @JoinColumn(name = "userTrashSmart")
    private UserTrashSmart userTrashSmart;
}

