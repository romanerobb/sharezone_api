package com.revature.sharezone.userprofile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

<<<<<<< HEAD
@Repository
public interface UserProfileDao extends CrudRepository<UserProfile, String> {
    @Query(value = "FROM User WHERE username= :username AND userpassword = : userpassword")
    Optional<UserProfile>  authenticateUserProfile(String username, String password);
=======

@Repository
public interface UserProfileDao extends CrudRepository<UserProfile, String> {
    @Query(value = "FROM User WHERE username= :username AND userpassword = : userpassword")
    Optional<UserProfile> authenticateUserProfile(String username, String password);
>>>>>>> cb8209170281249ccb6d6b190901c1418f8687f5
}
