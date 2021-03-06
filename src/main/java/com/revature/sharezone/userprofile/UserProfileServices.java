package com.revature.sharezone.userprofile;

import com.revature.sharezone.util.exceptions.AuthenticationException;
import com.revature.sharezone.util.exceptions.InvalidRequestException;
import com.revature.sharezone.util.exceptions.ResourcePersistenceException;
import com.revature.sharezone.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserProfileServices implements Serviceable<UserProfile> {

    private UserProfileDao userProfileDao;

    @Autowired
    public UserProfileServices(UserProfileDao userProfileDao){
        this.userProfileDao = userProfileDao;
    }

    @Override
    public List<UserProfile> readAll(){
        List<UserProfile> userProfiles = (List<UserProfile>) userProfileDao.findAll();
        return userProfiles;
    }


    public List<UserProfile> readAll(boolean is_subscriber){
        List<UserProfile> userProfiles = (List<UserProfile>) userProfileDao.findAllSubscriberUserProfile(is_subscriber);
        return userProfiles;
    }

    @Override
    public UserProfile readById(String id) throws ResourcePersistenceException{

        // Add .get() after findById as it is an Optional and not just a Trainer class that is returned byt he CrudRepository
        UserProfile userProfile = userProfileDao.findById(id).get();
        return userProfile;
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
            throw new InvalidRequestException("UserProfile input was not validated, either empty String or null values");
        }

        if(validateUsernameNotUsed(newUserProfile.getUsername())){
            throw new InvalidRequestException("Username is already in use. Please try again with another email or login into previous made account.");
        }

        UserProfile persistedUserProfile = userProfileDao.save(newUserProfile);

        if(persistedUserProfile == null){
            throw new ResourcePersistenceException("UserProfile was not persisted to the database upon registration");
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
        return newUserProfile.getAge() >= 13;

    }
    public UserProfile authenticateUserProfile(String username, String userpassword){

        if(userpassword == null || userpassword.trim().equals("") || username == null || username.trim().equals("")) {
            throw new InvalidRequestException("Either username or userpassword is an invalid entry. Please try logging in again");
        }
        Optional<UserProfile> authenticatedUserProfile = userProfileDao.authenticateUserProfile(username, userpassword);

        if (!authenticatedUserProfile.isPresent()){
            throw new AuthenticationException("Unauthenticated user, information provided was not consistent with our database.");
        }

        return authenticatedUserProfile.get();

    }


    public List<String> adminListUserProfile(boolean is_admin) {
        List<UserProfile> userProfileList = userProfileDao.adminUserProfile(is_admin);
        List<String> strList = new ArrayList<>();
        for( UserProfile userProfile : userProfileList ) {
            strList.add(userProfile.getUsername());
        }
        return strList;
    }

}



