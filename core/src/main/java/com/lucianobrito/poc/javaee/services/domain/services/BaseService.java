package com.lucianobrito.poc.javaee.services.domain.services;

import com.lucianobrito.poc.javaee.exceptions.errors.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

@Slf4j
public abstract class BaseService {
    private static final String PATTERN_MESSAGE = "Não foi possível realizar essa operação. Erro >>> {}";

    @Inject
    private ModelMapper modelMapper;

    protected <T, D> D entityToDto(T entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    protected BusinessException genericError(String message) {
        log.error(PATTERN_MESSAGE, message);
        return new BusinessException(message);
    }
}
