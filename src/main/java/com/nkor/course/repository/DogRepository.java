package com.nkor.course.repository;

import com.nkor.course.entity.DogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DogRepository extends MongoRepository<DogEntity, UUID> {

    DogEntity getByName(String name);
}
