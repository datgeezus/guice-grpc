package com.gato.grpc.router;

import io.grpc.BindableService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.AccessLevel;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class GrpcRouter {

    @NonNull private Class<? extends BindableService> serviceClass;

    GrpcRouter(final Class<? extends BindableService> serviceClass) {
        this.serviceClass = serviceClass;
    }
    
    public Class<? extends BindableService> getServiceClass() {
        return serviceClass;
    }
}