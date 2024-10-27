package com.nkor.course.repository;

import com.nkor.course.entity.CatEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CommonRepository<CatEntity, Long> {
}
