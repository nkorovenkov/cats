package com.nkor.course.controller;

import com.nkor.course.entity.CatEntity;
import com.nkor.course.kafka.KafkaProducer;
import com.nkor.course.service.CatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final KafkaProducer kafkaProducer;
    private final CatService catService;

    public KafkaController(KafkaProducer kafkaProducer, CatService catService) {
        this.kafkaProducer = kafkaProducer;
        this.catService = catService;
    }

    @PostMapping("/kafka/send")
    public String send(@RequestParam Long id) {
        kafkaProducer.sendMessage(catService.getEntityById(id).toString());
        return "Success";
    }
}
