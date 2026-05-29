package com.trashsmart.trash_smart_api.alert.web;

import com.trashsmart.trash_smart_api.alert.dtos.AlertDto;
import com.trashsmart.trash_smart_api.alert.services.AlertService;
import com.trashsmart.trash_smart_api.core.enums.AlertSeverity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
@io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "Bearer Authentication")
public class AlertController {

    private final AlertService alertService;

    @PostMapping
    public AlertDto createAlert(@RequestBody AlertDto alertDto) {
        return alertService.createAlert(alertDto);
    }

    @GetMapping
    public List<AlertDto> getAlerts(@RequestParam(required = false) AlertSeverity severity) {
        if (severity != null) {
            return alertService.getAlertsBySeverity(severity);
        }
        return alertService.getAllAlerts();
    }

    @PatchMapping("/{id}/acknowledge")
    public AlertDto acknowledgeAlert(@PathVariable Long id) {
        return alertService.acknowledgeAlert(id);
    }

    @GetMapping("/count")
    public long getAlertsCount() {
        return alertService.getTotalAlertsCount();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlertDto> getAlertById(@PathVariable Long id) {
        return ResponseEntity.ok(alertService.getAlertById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlert(@PathVariable Long id) {
        alertService.deleteAlert(id);
        return ResponseEntity.noContent().build(); // Retourne un standard 204 No Content
    }
}
