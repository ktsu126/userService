package com.user.user.adapter.persistence;

import com.user.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  User save(User user);

  Optional<User> findByUserId(Long userId);

  Optional<User> findByEmail(String email);

  List<User> findByName(String name);

}