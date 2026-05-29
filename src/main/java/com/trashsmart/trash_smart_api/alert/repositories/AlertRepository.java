package com.trashsmart.trash_smart_api.alert.repositories;

import com.trashsmart.trash_smart_api.alert.entites.Alert;
import com.trashsmart.trash_smart_api.core.enums.AlertSeverity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findBySeverity(AlertSeverity severity);
    List<Alert> findByIsAcknowledged(boolean isAcknowledged);
    long countBySeverity(AlertSeverity severity);
}
