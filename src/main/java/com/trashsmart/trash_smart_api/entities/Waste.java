package com.trashsmart.trash_smart_api.entities;

import com.trashsmart.trash_smart_api.enums.WasteType;
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

    private double weight;

    private LocalDateTime depositedAt;

    @Enumerated(EnumType.STRING)
    private WasteType type;

    @ManyToOne
    @JoinColumn(name = "trash_bin_id")
    private TrashBin trashBin;
}

