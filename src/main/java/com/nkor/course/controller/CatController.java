package com.nkor.course.controller;

import com.nkor.course.dto.CatDto;
import com.nkor.course.entity.CatEntity;
import com.nkor.course.repository.CatRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Tag(name = "cat_methods")
@Slf4j
@RestController
@RequiredArgsConstructor
public class CatController {
    private final CatRepository repository;
    private final ModelMapper modelMapper;

    @GetMapping("/api/all")
    public List<CatDto> getAll() {
        return repository.findAll().stream()
                .map(catEntity -> modelMapper.map(catEntity, CatDto.class))
                .collect(Collectors.toList());
    }

    @Operation(summary = "Создает нового котика и кладет в бд")
    @PostMapping("/api/create")
    public void create(@RequestBody CatDto catDto) {
        log.info("New Cat: {}", repository.save(modelMapper.map(catDto, CatEntity.class)));
    }

    @GetMapping("/api/getById/{id}")
    public CatDto getById(@PathVariable Long id) {
        return modelMapper.map(repository.findById(id).orElseThrow(), CatDto.class);
    }

    @DeleteMapping("/api/delete/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/api/update/{id}")
    public String update(@PathVariable Long id, @RequestBody CatDto catDto) {
        Optional<CatEntity> optionalCat = repository.findById(id);
        if (optionalCat.isPresent()) {
            CatEntity catEntity = optionalCat.get();
            modelMapper.map(catDto, catEntity);
            repository.save(catEntity);
            return "Cat updated successfully";
        } else {
            return "No such row";
        }
    }
}
