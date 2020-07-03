package com.gato.HelloGrpcServer;

import com.gato.grpc.AbstractGrpcServer;
import com.gato.grpc.router.GrpcRouter;
import com.gato.grpc.router.GrpcRouterBuilder;

public class HelloGrpcServer extends AbstractGrpcServer {

    @Override
    protected GrpcRouter configureGrpc(GrpcRouterBuilder builder) {
        return builder.addService(GreeterController.class).build();
    }


}