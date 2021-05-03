package com.example.user.api;

import com.example.user.domain.User;
import com.example.user.exception.UserException;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetUser {
  private UserService userService;

  @Autowired
  GetUser(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUser(@PathVariable("id") int id) throws UserException {
    User user = userService.getUser(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }
}
