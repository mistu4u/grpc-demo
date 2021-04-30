package com.example.payapp.api;

import com.example.payapp.api.service.user.User;
import com.example.user.grpc.services.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Account {
  @Autowired
  private User user;

  @RequestMapping("/balance/{id}")
  public ResponseEntity<String> getBalance(@PathVariable("id") int id) {
    final GetUserResponse userInfo = user.getUserInfo(id);
    if (!ObjectUtils.isEmpty(userInfo)) {
      return new ResponseEntity<>(userInfo.getName(), HttpStatus.OK);
    }
    return new ResponseEntity<>("Invalid user", HttpStatus.NOT_FOUND);
  }
}
