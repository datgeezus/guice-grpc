package com.gato.grpc;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractApp {

    private Injector injector;

    public Injector injector() {
        return injector;
    }

    protected Collection<Module> modules() {
        return Collections.emptyList();
    }

    Collection<Module> systemModules() {
        return Collections.emptyList();
    }

    public void main() {
        injector = loadModules();
        postInjector();
        start();
    }

    private Injector loadModules() {
        return Guice.createInjector(
            Stream.concat(
                systemModules().stream(),
                modules().stream()
            ).collect(Collectors.toList())
        );
    }
    
    protected void run() {}

    protected void postInjector() {}

    private void start() {
        try {
            run();
        } catch (final Exception e) {
            //TODO: handle exception
        }
    }
}