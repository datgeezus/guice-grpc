package com.gato.HelloGrpcServer;

import com.google.inject.Singleton;

import io.grpc.helloworld.HelloReply;
import io.grpc.helloworld.HelloRequest;
import io.grpc.helloworld.GreeterGrpc.GreeterImplBase;
import io.grpc.stub.StreamObserver;

@Singleton
public class GreeterController extends GreeterImplBase {

    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> resp) {
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello" + req.getName()).build();

        resp.onNext(reply);
        resp.onCompleted();
    }
}