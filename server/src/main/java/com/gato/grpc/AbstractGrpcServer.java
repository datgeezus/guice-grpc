package com.gato.grpc;

import java.util.Arrays;
import java.util.Collection;

import com.gato.grpc.modules.UserServiceModule;
import com.gato.grpc.router.GrpcRouter;
import com.gato.grpc.router.GrpcRouterBuilder;
import com.google.inject.Module;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class AbstractGrpcServer extends AbstractServer {

    private static final int DEFAULT_PORT = 50051;

    protected int defaultGrpcPort() {
        return DEFAULT_PORT;
    }

    protected abstract GrpcRouter configureGrpc(GrpcRouterBuilder builder);

    Collection<Module> controllerModules() {
        return Arrays.asList(
            new UserServiceModule(
                configureGrpc(new GrpcRouterBuilder()).getServiceClass()
            )
        );
    }

    @Override
    protected void run() {
        try {
            injector()
                .getInstance(GrpcServer.class)
                .start(defaultGrpcPort())
                .awaitTermination();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}