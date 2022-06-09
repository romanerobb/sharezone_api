package com.revature.sharezone.userprofile;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserProfileDao extends CrudRepository<UserProfile, String> {
    @Query(value = "FROM Trainer WHERE email= :email AND password = :password")
    Trainer authenticateTrainer(String email, String password);
}
