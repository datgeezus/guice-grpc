package com.gato.grpc.router;

import io.grpc.BindableService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GrpcRouterBuilder {

    private Class<? extends BindableService> clazz;

    public GrpcRouterBuilder addService(Class<? extends BindableService> clazz) {
        this.clazz = clazz;
        return this;
    }

    public GrpcRouter build() {
        return new GrpcRouter(clazz);
    }
    
}