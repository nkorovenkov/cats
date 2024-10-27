package com.nkor.course.service;

import com.nkor.course.dto.CatDto;
import com.nkor.course.entity.CatEntity;
import com.nkor.course.repository.CatRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CatService extends AbstractService<CatRepository, CatEntity> {
    private final ModelMapper modelMapper;

    public CatService(CatRepository repository, ModelMapper modelMapper) {
        super(repository);
        this.modelMapper = modelMapper;
    }

    public List<CatDto> getAllDto() {
        return getAll().stream()
                .map(catEntity -> modelMapper.map(catEntity, CatDto.class))
                .collect(Collectors.toList());
    }

    public CatDto create(CatDto catDto) {
        CatEntity cat = save(modelMapper.map(catDto, CatEntity.class));
        log.info("New Cat: {}", cat);
        return modelMapper.map(cat, CatDto.class);
    }

    public CatDto getById(Long id) {
        return modelMapper.map(getEntityById(id), CatDto.class);
    }

    public CatDto deleteById(Long id) {
        return modelMapper.map(delete(id), CatDto.class);
    }

    public CatDto update(Long id, CatDto catDto) {
        CatEntity cat = getEntityById(id);
        modelMapper.map(catDto, cat);
        return modelMapper.map(save(cat), CatDto.class);
    }
}
