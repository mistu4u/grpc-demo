package com.example.user;

import com.example.user.grpc.GrpcImpl;
import com.example.user.service.UserService;
import com.example.user.service.UserServiceImpl;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.user.grpc"})
public class UserApplication {
  public static void main(String[] args) throws IOException, InterruptedException {
    SpringApplication.run(UserApplication.class, args);
    Server server = ServerBuilder.forPort(7990)
            .addService(new GrpcImpl(new UserServiceImpl()))
            .build();
    server.start();
    System.out.println("Server started on port " + server.getPort());
    server.awaitTermination();
  }

}
