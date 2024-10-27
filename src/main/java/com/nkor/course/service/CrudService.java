package com.nkor.course.service;

import com.nkor.course.repository.CommonRepository;

import java.util.List;
import java.util.Optional;

public interface CrudService<R extends CommonRepository<E, Long>, E> {

    E save(E entity);

    E delete(E entity);

    E delete(Long id);

    Optional<E> findById(long id);

    E getEntityById(long id);

    List<E> getAll();
}