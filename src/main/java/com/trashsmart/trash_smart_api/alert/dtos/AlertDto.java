package com.trashsmart.trash_smart_api.alert.dtos;

import com.trashsmart.trash_smart_api.core.enums.AlertSeverity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertDto {
    private Long id;
    private AlertSeverity severity;
    private String description;
    private LocalDateTime createdAt;
    private boolean isAcknowledged;
    private Long trashcanId;
    // Optionnel : renvoyer le nom ou la référence de la poubelle pour faciliter l'affichage côté Angular
    private String trashcanReference;
}
