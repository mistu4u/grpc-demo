package com.example.user.grpc;

import com.example.user.service.UserService;
import com.example.user.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceMaker {
  @Bean
  public UserService userService(){
    return new UserServiceImpl();
  }
}
