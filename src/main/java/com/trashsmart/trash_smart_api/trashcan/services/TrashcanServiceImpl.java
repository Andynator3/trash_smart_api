package com.trashsmart.trash_smart_api.trashcan.services;

import com.trashsmart.trash_smart_api.trashcan.dtos.TrashcanDto;
import com.trashsmart.trash_smart_api.trashcan.entities.Trashcan;
import com.trashsmart.trash_smart_api.trashcan.mappers.TrashcanMapper;
import com.trashsmart.trash_smart_api.trashcan.repositories.TrashcanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrashcanServiceImpl implements TrashcanService {

    private final TrashcanRepository trashcanRepository;
    private final TrashcanMapper trashcanMapper;

    @Override
    public TrashcanDto addTrashcan(TrashcanDto trashcanDto) {
        Trashcan trashcan = trashcanMapper.toEntity(trashcanDto);
        Trashcan savedTrashcan = trashcanRepository.save(trashcan);
        return trashcanMapper.toDto(savedTrashcan);
    }

    @Override
    public List<TrashcanDto> getAllTrashcans() {
        return trashcanRepository.findAll().stream()
                .map(trashcanMapper::toDto)
                .collect(Collectors.toList());
    }
}

