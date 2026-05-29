package com.trashsmart.trash_smart_api.waste.web;


import com.trashsmart.trash_smart_api.waste.dtos.WasteDto;
import com.trashsmart.trash_smart_api.waste.services.WasteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/wastes")
@RequiredArgsConstructor
@io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "Bearer Authentication")
public class WasteController {

    private final WasteService wasteService;

    @PostMapping
    public WasteDto createWaste(@RequestBody WasteDto wasteDto) {
        return wasteService.addWaste(wasteDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WasteDto> getWasteById(@PathVariable Long id) {
        return ResponseEntity.ok(wasteService.getWasteById(id));
    }

    @GetMapping
    public List<WasteDto> getAll() {
        return wasteService.getAllWastes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<WasteDto> updateWaste(@PathVariable Long id, @RequestBody WasteDto wasteDto) {
        return ResponseEntity.ok(wasteService.updateWaste(id, wasteDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWaste(@PathVariable Long id) {
        wasteService.deleteWaste(id);
        return ResponseEntity.noContent().build(); // Retourne un code 204 No Content
    }

    // Route analytique cruciale pour le frontend
    @GetMapping("/trashcan/{trashcanId}")
    public ResponseEntity<List<WasteDto>> getWastesByTrashcanId(@PathVariable Long trashcanId) {
        return ResponseEntity.ok(wasteService.getWastesByTrashcanId(trashcanId));
    }

}

