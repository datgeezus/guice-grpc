package com.gato.grpc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import com.gato.grpc.controllers.HealthCheckServiceController;
import com.google.inject.name.Named;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
class GrpcServer {

    private Server grpcServer;

    @Inject
    private HealthCheckServiceController healthService;

    @Inject
    @Named("UserService")
    private BindableService userService;

    final Server start(int port) {

        grpcServer = ServerBuilder
            .forPort(port)
            .addService(healthService)
            .addService(userService)
            .build();

        System.out.println("Server started");
        try {
            grpcServer.start();
            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    // Use stderr here since the logger may have been reset by its JVM shutdown
                    // hook.
                    System.err.println("*** shutting down gRPC server since JVM is shutting down");
                    try {
                        GrpcServer.this.stop();
                    } catch (InterruptedException e) {
                        e.printStackTrace(System.err);
                    }
                    System.err.println("*** server shut down");
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return grpcServer;
    }

    private void stop() throws InterruptedException {
        if (grpcServer != null) {
            grpcServer.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }
}