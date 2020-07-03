package com.gato.grpc.router;

import io.grpc.BindableService;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GrpcRouterBuilder {

    private Class<? extends BindableService> serviceClass;

    public GrpcRouterBuilder addService(Class<? extends BindableService> clazz) {
        serviceClass = clazz;
        return this;
    }

    public GrpcRouter build() {
        return new GrpcRouter(this.serviceClass);
    }
    
}