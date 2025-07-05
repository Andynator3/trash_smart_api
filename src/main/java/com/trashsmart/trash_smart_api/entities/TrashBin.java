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

    private String name;
    private double latitude;
    private double longitude;
    @Column(name = "is_full")
    private boolean full;
    @OneToMany(mappedBy = "trashBin", cascade = CascadeType.ALL)
    private List<Waste> wastes = new ArrayList<>();

}

