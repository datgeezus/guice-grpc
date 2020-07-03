package com.gato.grpc.modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import io.grpc.BindableService;

public class UserServiceModule extends AbstractModule {

    private final Class<? extends BindableService> clazz;

    public UserServiceModule(Class<? extends BindableService> clazz) {
        this.clazz = clazz;
    }

    @Override
    protected void configure() {
        bind(BindableService.class)
            .annotatedWith(Names.named("UserService"))
            .to(clazz);
    }
    
}