package com.trashsmart.trash_smart_api.waste.services;

import com.trashsmart.trash_smart_api.waste.dtos.WasteDto;

import java.util.List;

public interface WasteService {
    WasteDto addWaste(WasteDto wasteDto);
    WasteDto getWasteById(Long id);
    List<WasteDto> getAllWastes();
    WasteDto updateWaste(Long id, WasteDto wasteDto);
    void deleteWaste(Long id);
    List<WasteDto> getWastesByTrashcanId(Long trashcanId);
}

