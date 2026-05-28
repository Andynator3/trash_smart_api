package com.trashsmart.trash_smart_api.trashcan.entities;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Trashcan {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private double latitude;
    private double longitude;
    private boolean isFull;
    private boolean isBlocked;

    /*
    @OneToMany(mappedBy = "trashBin", cascade = CascadeType.ALL)
    private List<Waste> wastes = new ArrayList<>();*/

}

