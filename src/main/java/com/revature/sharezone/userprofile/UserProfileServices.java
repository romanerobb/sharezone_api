package com.revature.sharezone.userprofile;


import org.springframework.boot.actuate.endpoint.InvalidEndpointRequestException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserProfileServices  implements Serviceable<UserProfile>{

    private UserProfileDao userProfileDao;

    public UserProfileServices(UserProfileDao userProfileDao){
        this.userProfileDao = userProfileDao;
    }

    @Override
    public List<UserProfile> readAll(){
        List<UserProfile> userProfiles = (List<UserProfile>) userProfileDao.findAll();
        return userProfiles;
    }

    @Override
    public UserProfile update(UserProfile updatedUserProfile){
        userProfileDao.save(updatedUserProfile);

        return updatedUserProfile;
    }

    @Override
    public boolean delete(String username){
        userProfileDao.deleteById(username);
        return true;
    }

    public boolean validateUsernameNotUsed(String username){
        return userProfileDao.existsById(username);
    }

    public UserProfile create(UserProfile newUserProfile){
        if(!validateInput(newUserProfile)){
            throw new InvalidEndpointRequestException();
        }

        if(validateUsernameNotUsed(newUserProfile.getUsername())){
            throw new InvalidRequestException();
        }

        UserProfile persistedUserProfile = userProfileDao.save(newUserProfile);

        if(persistedUserProfile == null){
            throw new ResourcePersistanceException()
        }
        return persistedUserProfile;
    }

    @Override
    public boolean validateInput(UserProfile newUserProfile) {
        if (newUserProfile == null) return false;
        if (newUserProfile.getFname() == null || newUserProfile.getFname().trim().equals("")) return false;
        if (newUserProfile.getLname() == null || newUserProfile.getLname().trim().equals("")) return false;
        if (newUserProfile.getEmailaddress() == null || newUserProfile.getEmailaddress().trim().equals(""))
            return false;
        if (newUserProfile.getUserpassword() == null || newUserProfile.getUserpassword().trim().equals(""))
            return false;
        return newUserProfile.getAge() < 13;
        return false;

    }
    public UserProfile authenticateUserProfile(String username, String password){

        if(password == null || password.trim().equals("") || username == null || username.trim().equals("")) {
            throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
        }

        UserProfile authenticatedUserProfile = userProfileDao.authenticateUserProfile(username, password);

        if (authenticatedUserProfile == null){
            throw new AuthenticationException("Unauthenticated user, information provided was not consistent with our database.");
        }

        return authenticatedUserProfile;

    }

    }



