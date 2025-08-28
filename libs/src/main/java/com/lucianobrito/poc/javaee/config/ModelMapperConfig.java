package com.lucianobrito.poc.javaee.config;

import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ModelMapperConfig {

    @Produces
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
