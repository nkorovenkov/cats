package com.nkor.course.controller;

import com.nkor.course.dto.CatDto;
import com.nkor.course.service.CatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "cat_methods")
@Slf4j
@RestController
@RequiredArgsConstructor
public class CatController {
    private final CatService catService;

    @GetMapping("/api/all")
    public List<CatDto> getAll() {
        return catService.getAllDto();
    }

    @Operation(summary = "Создает нового котика и кладет в бд")
    @PostMapping("/api/create")
    public CatDto create(@RequestBody CatDto catDto) {
       return catService.create(catDto);
    }

    @GetMapping("/api/getById/{id}")
    public CatDto getById(@PathVariable Long id) {
        return catService.getById(id);
    }

    @DeleteMapping("/api/delete/{id}")
    public CatDto delete(@PathVariable Long id) {
        return catService.deleteById(id);
    }

    @PutMapping("/api/update/{id}")
    public CatDto update(@PathVariable Long id, @RequestBody CatDto catDto) {
       return catService.update(id, catDto);
    }
}
