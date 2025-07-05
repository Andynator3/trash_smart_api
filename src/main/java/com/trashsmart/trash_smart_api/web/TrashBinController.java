package com.trashsmart.trash_smart_api.web;

import com.trashsmart.trash_smart_api.dtos.TrashBinDTO;
import com.trashsmart.trash_smart_api.entities.TrashBin;
import com.trashsmart.trash_smart_api.mappers.TrashBinMapper;
import com.trashsmart.trash_smart_api.services.TrashBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trash-bins")
@RequiredArgsConstructor
public class TrashBinController {

    private final TrashBinService trashBinService;
    private final TrashBinMapper trashBinMapper;


    @PostMapping
    public TrashBinDTO save(@RequestBody TrashBinDTO dto) {
        TrashBin bin = trashBinMapper.fromDTO(dto);
        TrashBin saved = trashBinService.save(bin);
        return trashBinMapper.toDTO(saved);
    }

    @GetMapping
    public List<TrashBinDTO> getAll() {
        return trashBinService.getAll().stream()
                .map(trashBinMapper::toDTO)
                .toList();
    }


    @GetMapping("/{id}")
    public TrashBinDTO getById(@PathVariable Long id) {
        TrashBin bin = trashBinService.getById(id);
        return trashBinMapper.toDTO(bin);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        trashBinService.delete(id);
    }

    @GetMapping("/search")
    public List<TrashBin> searchByName(@RequestParam String keyword) {
        return trashBinService.searchByName(keyword);
    }

    @GetMapping("/full")
    public List<TrashBin> getFullBins() {
        return trashBinService.getFullTrashBins();
    }

    @GetMapping("/nearby")
    public List<TrashBinDTO> getNearby(@RequestParam double lat,
                                       @RequestParam double lng,
                                       @RequestParam(defaultValue = "1.0") double radiusKm) {
        return trashBinService.getNearby(lat, lng, radiusKm).stream()
                .map(trashBinMapper::toDTO)
                .toList();
    }
}

