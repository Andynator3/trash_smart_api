package com.trashsmart.trash_smart_api.web;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/wastes")
@RequiredArgsConstructor
public class WasteController {

   // private final WasteService wasteService;

   /* @PostMapping("/trash-bin/{trashBinId}")
    public Waste saveWaste(@PathVariable Long trashBinId, @RequestBody Waste waste) {
        return wasteService.saveWaste(waste, trashBinId);
    }*/

   /* @GetMapping
    public List<Waste> getAllWastes() {
        return wasteService.getAllWastes();
    }*/

   /* @GetMapping("/trash-bin/{trashBinId}")
    public List<Waste> getByTrashBin(@PathVariable Long trashBinId) {
        return wasteService.getWastesByTrashBin(trashBinId);
    }*/
}

