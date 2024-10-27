package com.nkor.course.service;

import com.nkor.course.entity.AbstractEntity;
import com.nkor.course.exception.HttpCode;
import com.nkor.course.exception.HttpCodeException;
import com.nkor.course.repository.CommonRepository;

import java.util.List;
import java.util.Optional;

public abstract class AbstractService<R extends CommonRepository<E, Long>, E extends AbstractEntity>
        implements CrudService<R, E> {

    private final R repository;

    protected AbstractService(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Override
    public E delete(E entity) {
        repository.delete(entity);
        return entity;
    }

    @Override
    public E delete(Long id) {
        return delete(getEntityById(id));
    }

    @Override
    public Optional<E> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public E getEntityById(long id) {
        return findById(id).orElseThrow(
                () -> new HttpCodeException(
                        HttpCode.NOT_FOUND_404,
                        String.format("Entity not found by id %d", id)));
    }

    @Override
    public List<E> getAll() {
        return repository.findAll();
    }
}