package com.netcetera.clothingshop.repository;

import com.netcetera.clothingshop.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Provides a Repository for Users.
 */
@Repository
public interface UserRepository extends BaseRepository<User> {

  /**
   * Finds a User by his Username.
   *
   * @param username is his username.
   * @return the user2.
   */
  User findByUsername(String username);

}
