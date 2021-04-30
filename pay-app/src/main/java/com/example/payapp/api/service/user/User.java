package com.example.payapp.api.service.user;

import com.example.user.grpc.services.GetUserResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class User {
  ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 7990).usePlaintext().build();

  com.example.user.grpc.services.UserRPCServiceGrpc.UserRPCServiceBlockingStub stub = com.example.user.grpc.services.UserRPCServiceGrpc.newBlockingStub(channel);

  /**
   * Get the user information through RPC from user microservice
   *
   * @param id
   * @return GetUserResponse
   */
  public GetUserResponse getUserInfo(int id) {
    com.example.user.grpc.services.GetUserRequest request =
            com.example.user.grpc.services.GetUserRequest.newBuilder().setId(id).build();
    com.example.user.grpc.services.GetUserResponse getUserResponse = stub.retrieveUser(request);
    return getUserResponse;
  }
}
