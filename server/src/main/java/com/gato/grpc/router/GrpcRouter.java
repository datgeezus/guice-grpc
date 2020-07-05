package com.gato.grpc.router;

import io.grpc.BindableService;
import lombok.RequiredArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.AccessLevel;

@RequiredArgsConstructor(access = AccessLevel.MODULE)
public class GrpcRouter {
    @Getter
    @NonNull
    private Class<? extends BindableService> serviceClass;
}