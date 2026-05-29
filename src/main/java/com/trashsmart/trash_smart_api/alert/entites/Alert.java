package com.trashsmart.trash_smart_api.alert.entites;

import com.trashsmart.trash_smart_api.core.enums.AlertSeverity;
import com.trashsmart.trash_smart_api.trashcan.entities.Trashcan;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Alert {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AlertSeverity severity;

    private String description;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    private boolean isAcknowledged = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trashcan_id")
    private Trashcan trashcan;
    private String trashcanReference;
}