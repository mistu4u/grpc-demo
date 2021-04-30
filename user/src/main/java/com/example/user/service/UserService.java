package com.example.user.service;

import com.example.user.domain.User;
import com.example.user.exception.UserException;

public interface UserService {
  public User getUser(int id) throws UserException;
}
