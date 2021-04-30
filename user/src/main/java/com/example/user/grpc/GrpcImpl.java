package com.example.user.grpc;

import com.example.user.domain.User;
import com.example.user.exception.UserException;
import com.example.user.grpc.services.GetUserRequest;
import com.example.user.grpc.services.GetUserResponse;
import com.example.user.grpc.services.UserRPCServiceGrpc;
import com.example.user.service.UserService;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class GrpcImpl extends UserRPCServiceGrpc.UserRPCServiceImplBase {
  private User user;
  private final UserService userService;

  public GrpcImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public void retrieveUser(GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {
    try {
      System.out.println(request);
      user = userService.getUser(request.getId());
    } catch (UserException e) {
      responseObserver.onError(e);
    }
    if (!ObjectUtils.isEmpty(user)) {
      responseObserver.onNext(GetUserResponse.newBuilder().setName(user.getName()).build());
    } else{
      responseObserver.onNext(GetUserResponse.newBuilder().setName("").build());
    }
    responseObserver.onCompleted();
  }
}
