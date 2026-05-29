package com.trashsmart.trash_smart_api.alert.services;

import com.trashsmart.trash_smart_api.alert.dtos.AlertDto;
import com.trashsmart.trash_smart_api.core.enums.AlertSeverity;

import java.util.List;

public interface AlertService {
    AlertDto createAlert(AlertDto alertDto);
    List<AlertDto> getAllAlerts();
    List<AlertDto> getAlertsBySeverity(AlertSeverity severity);
    AlertDto acknowledgeAlert(Long id);
    long getTotalAlertsCount();
}
