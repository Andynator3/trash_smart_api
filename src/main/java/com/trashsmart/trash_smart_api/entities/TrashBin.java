package com.trashsmart.trash_smart_api.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrashBin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String locationName;
    private double latitude;
    private double longitude;
    private boolean isFull;
    private boolean isBlocked;
    @OneToMany(mappedBy = "trashBin", cascade = CascadeType.ALL)
    private List<Waste> wastes = new ArrayList<>();

}

