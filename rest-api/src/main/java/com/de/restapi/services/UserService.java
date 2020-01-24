package com.de.restapi.services;

import com.de.restapi.models.User;
import com.de.restapi.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> retrieveUsers() {
    return userRepository.findAll();
  }

  public Optional<User> retrieveUser(Long id) {
    return userRepository.findById(id);
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }
}
