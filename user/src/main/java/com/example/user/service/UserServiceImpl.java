package com.example.user.service;

import com.example.user.domain.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Configuration
public class UserServiceImpl implements UserService {
  @Override
  public User getUser(int id) {
    if (id == 123) {
      return User.builder()
              .id(123)
              .name("Subir Adhikari")
              .userType("Customer")
              .phoneNumber("9153077226")
              .build();
    }
    return null;
  }
}
