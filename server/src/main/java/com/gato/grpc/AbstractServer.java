package com.gato.grpc;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.inject.Module;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractServer extends AbstractApp {

    @Override
    public void main() {
        super.main();
    }

    abstract Collection<Module> controllerModules();

    protected void setup() {
    }

    @Override
    protected Collection<Module> systemModules() {
        return Stream.concat(
            super.systemModules().stream(),
            controllerModules().stream()
        ).collect(Collectors.toList());
    }

    @Override
    protected void postInjector() {
        super.postInjector();
        setup();
    }

    @Override
    protected void run() {
        start();
    }

    protected void start() {
    }
    
}