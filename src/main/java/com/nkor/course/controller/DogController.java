package com.nkor.course.controller;

import com.nkor.course.entity.DogEntity;
import com.nkor.course.exception.response.AbstractBaseResponseMessage;
import com.nkor.course.exception.HttpCode;
import com.nkor.course.exception.HttpCodeException;
import com.nkor.course.exception.response.ResponseHelper;
import com.nkor.course.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("dog")
@RequiredArgsConstructor
public class DogController {
    private final DogRepository dogRepository;

    @GetMapping("/all")
    public AbstractBaseResponseMessage<List<DogEntity>> getAll() {
        return ResponseHelper.success(dogRepository.findAll());
    }

    @GetMapping("/getById/{id}")
    public AbstractBaseResponseMessage<DogEntity> getById( @PathVariable UUID id) {
        return ResponseHelper.success(dogRepository.findById(id)
                .orElseThrow(() -> new HttpCodeException(HttpCode.NOT_FOUND_404)));
    }

    @PostMapping("/create")
    public AbstractBaseResponseMessage<DogEntity> createDog(@RequestBody DogEntity dog) {
        dog.setId(UUID.randomUUID());
        return ResponseHelper.success(dogRepository.save(dog));
    }
}
