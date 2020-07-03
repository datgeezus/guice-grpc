package com.gato.HelloApp;

import java.util.Collection;
import java.util.Collections;

import com.gato.grpc.AbstractApp;
import com.google.inject.Module;

public class HelloWorldApp extends AbstractApp {
    public HelloWorldApp() {

    }

    @Override
    public Collection<Module> modules() {
        return Collections.emptyList();
    }

    @Override
    public void run() {
        HelloService helloService = injector().getInstance(HelloService.class);
        System.out.println(helloService.hi("World"));
    }
}
