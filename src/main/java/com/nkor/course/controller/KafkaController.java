package com.nkor.course.controller;

import com.nkor.course.service.kafka.KafkaProducerService;
import com.nkor.course.service.CatService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class KafkaController {
    private final KafkaProducerService kafkaProducerService;
    private final CatService catService;

    public KafkaController(KafkaProducerService kafkaProducerService, CatService catService) {
        this.kafkaProducerService = kafkaProducerService;
        this.catService = catService;
    }

    @PostMapping("/sendCatById/{id}")
    public void sendCatById(@PathVariable Long id) {
        kafkaProducerService.sendMessage(catService.getEntityById(id).toString());
    }

    @PostMapping("/sendAllCats")
    public void sendAllCats() {
        kafkaProducerService.sendMessage(catService.getAll().toString());
    }
}
