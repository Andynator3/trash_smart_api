package com.trashsmart.trash_smart_api.alert.services;

import com.trashsmart.trash_smart_api.alert.dtos.AlertDto;
import com.trashsmart.trash_smart_api.alert.entites.Alert;
import com.trashsmart.trash_smart_api.alert.mappers.AlertMapper;
import com.trashsmart.trash_smart_api.alert.repositories.AlertRepository;
import com.trashsmart.trash_smart_api.core.enums.AlertSeverity;
import com.trashsmart.trash_smart_api.trashcan.entities.Trashcan;
import com.trashsmart.trash_smart_api.trashcan.repositories.TrashcanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;
    private final TrashcanRepository trashcanRepository;
    private final AlertMapper alertMapper;

    @Override
    public AlertDto createAlert(AlertDto alertDto) {
        Trashcan trashcan = null;
        if (alertDto.getTrashcanId() != null) {
            trashcan = trashcanRepository.findById(alertDto.getTrashcanId())
                    .orElseThrow(() -> new RuntimeException("Poubelle introuvable avec l'ID: " + alertDto.getTrashcanId()));
        }
        Alert alert = alertMapper.toEntity(alertDto, trashcan);
        return alertMapper.toDto(alertRepository.save(alert));
    }

    @Override
    public List<AlertDto> getAllAlerts() {
        return alertRepository.findAll().stream()
                .map(alertMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<AlertDto> getAlertsBySeverity(AlertSeverity severity) {
        return alertRepository.findBySeverity(severity).stream()
                .map(alertMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public AlertDto acknowledgeAlert(Long id) {
        Alert alert = alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerte introuvable avec l'ID: " + id));
        alert.setAcknowledged(true);
        return alertMapper.toDto(alertRepository.save(alert));
    }

    @Override
    public long getTotalAlertsCount() {
        return alertRepository.count();
    }

    @Override
    public AlertDto getAlertById(Long id) {
        Alert alert = alertRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerte introuvable avec l'ID : " + id));
        return alertMapper.toDto(alert); // Utilise ton mapper existant
    }

    @Override
    public void deleteAlert(Long id) {
        if (!alertRepository.existsById(id)) {
            throw new RuntimeException("Alerte introuvable avec l'ID : " + id);
        }
        alertRepository.deleteById(id);
    }
}
