package com.gato.grpc.controllers;

import javax.inject.Singleton;

import io.grpc.health.v1.HealthCheckRequest;
import io.grpc.health.v1.HealthCheckResponse;
import io.grpc.health.v1.HealthGrpc;
import io.grpc.health.v1.HealthCheckResponse.ServingStatus;
import io.grpc.stub.StreamObserver;

@Singleton
public class HealthCheckServiceController extends HealthGrpc.HealthImplBase {
    
    @Override
    public void check(HealthCheckRequest req, StreamObserver<HealthCheckResponse> rep) {
        HealthCheckResponse status = HealthCheckResponse.newBuilder().setStatus(ServingStatus.SERVING).build();
        rep.onNext(status);
        rep.onCompleted();
    }

    @Override
    public void watch(HealthCheckRequest req, StreamObserver<HealthCheckResponse> rep) {
        HealthCheckResponse status = HealthCheckResponse.newBuilder().setStatus(ServingStatus.SERVING).build();
        rep.onNext(status);
        rep.onCompleted();
    }
}