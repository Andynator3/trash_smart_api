package com.trashsmart.trash_smart_api.web;

import com.trashsmart.trash_smart_api.dtos.TrashBinDTO;
import com.trashsmart.trash_smart_api.entities.TrashBin;
import com.trashsmart.trash_smart_api.mappers.TrashBinMapper;
import com.trashsmart.trash_smart_api.services.TrashBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TrashBinController {

    private final TrashBinService trashBinService;
    private final TrashBinMapper trashBinMapper;


    @PostMapping("/trashbins")
    public TrashBinDTO save(@RequestBody TrashBinDTO dto) {
        TrashBin bin = trashBinMapper.fromDTO(dto);
        TrashBin saved = trashBinService.createTrashBin(bin);
        return trashBinMapper.toDTO(saved);
    }

    @GetMapping("/trashbins")
    public List<TrashBinDTO> getAll() {
        return trashBinService.getAllTrashBins()
                .stream()
                .map(trashBinMapper::toDTO)
                .collect(Collectors
                .toList());
    }


   /* @GetMapping("/trash-bin/{id}")
    public TrashBinDTO getById(@PathVariable Long id) {
        TrashBin bin = trashBinService.getTrashBinById(id);
        return trashBinMapper.toDTO(bin);
    }*/


   /* @DeleteMapping("/trash-bin/{id}")
    public void delete(@PathVariable Long id) {
        trashBinService.deleteTrashBin(id);
    }*/

   /* @GetMapping("/trash-bin/search")
    public List<TrashBin> searchByName(@RequestParam String keyword) {
        return trashBinService.searchByName(keyword);
    }*/

   /* @GetMapping("/trash-bin/full")
    public List<TrashBin> getFullBins() {
        return trashBinService.getFullTrashBins();
    }*/

   /* @GetMapping("/trash-bin/nearby")
    public List<TrashBinDTO> getNearby(@RequestParam double lat,
                                       @RequestParam double lng,
                                       @RequestParam(defaultValue = "1.0") double radiusKm) {
        return trashBinService.getNearby(lat, lng, radiusKm).stream()
                .map(trashBinMapper::toDTO)
                .toList();
    }*/
}

