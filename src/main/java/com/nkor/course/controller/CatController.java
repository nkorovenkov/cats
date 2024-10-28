package com.nkor.course.controller;

import com.nkor.course.dto.CatDto;
import com.nkor.course.exception.response.AbstractBaseResponseMessage;
import com.nkor.course.exception.response.ResponseHelper;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "cat_methods")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("cat")
public class CatController {
    private final CatService catService;

    @GetMapping("/all")
    public AbstractBaseResponseMessage<List<CatDto>> getAll() {
        return ResponseHelper.success(catService.getAllDto());
    }

    @Operation(summary = "Создает нового котика и кладет в бд")
    @PostMapping("/create")
    public AbstractBaseResponseMessage<CatDto> create(@RequestBody CatDto catDto) {
       return ResponseHelper.success(catService.create(catDto));
    }

    @GetMapping("/getById/{id}")
    public AbstractBaseResponseMessage<CatDto> getById(@PathVariable Long id) {
        return ResponseHelper.success(catService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public AbstractBaseResponseMessage<CatDto> delete(@PathVariable Long id) {
        return ResponseHelper.success(catService.deleteById(id));
    }

    @PutMapping("/update/{id}")
    public AbstractBaseResponseMessage<CatDto> update(@PathVariable Long id, @RequestBody CatDto catDto) {
       return ResponseHelper.success(catService.update(id, catDto));
    }
}
