package com.revature.sharezone.userprofile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProfileDao extends CrudRepository<UserProfile, String> {

    @Query(value = "FROM UserProfile WHERE username= :username AND userpassword = :userpassword")
    Optional<UserProfile> authenticateUserProfile(String username, String userpassword);

    @Query(value = "FROM UserProfile WHERE is_admin = :is_admin")
    List<UserProfile> adminUserProfile(boolean is_admin);

}
