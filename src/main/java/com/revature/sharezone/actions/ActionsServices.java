package com.revature.sharezone.actions;

import com.revature.sharezone.contents.Contents;
import com.revature.sharezone.contents.ContentsDao;
import com.revature.sharezone.userprofile.UserProfile;
import com.revature.sharezone.userprofile.UserProfileDao;
import com.revature.sharezone.util.exceptions.InvalidRequestException;
import com.revature.sharezone.util.exceptions.ResourcePersistenceException;
import com.revature.sharezone.util.interfaces.Serviceable;
import com.revature.sharezone.util.web.dto.ActionsInitalizer;
import org.apache.catalina.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.annotation.ExceptionProxy;


import javax.jws.soap.SOAPBinding;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ActionsServices implements Serviceable<Actions> {

    private final ActionsDao actionsDao;
    private final ContentsDao contentsDao;

    private final UserProfileDao userProfileDao;


    @Autowired
    public ActionsServices(ActionsDao actionsDao, ContentsDao contentsDao, UserProfileDao userProfileDao) {
        this.actionsDao = actionsDao;
        this.contentsDao = contentsDao;
        this.userProfileDao = userProfileDao;
    }

    @Override
    public Actions create (Actions newActions) {
        return actionsDao.save(newActions);
    }

    public Actions create (ActionsInitalizer actionsInitalizer) {
        Actions newActions = new Actions();

        UserProfile userProfile = userProfileDao.findById(actionsInitalizer.getUsername()).get();
        Contents contents = contentsDao.findById(actionsInitalizer.getContentsid()).get();

        newActions.setContentsid(contents);
        newActions.setUsername(userProfile);
        newActions.setUsercomment(actionsInitalizer.getUsercomment());
        newActions.setUserlike(actionsInitalizer.getUserlike());
        newActions.setUsercomment(actionsInitalizer.getUsercomment());
        newActions.setUserstatus(actionsInitalizer.getUserstatus());

        return actionsDao.save(newActions);
    }

    @Override
    public List<Actions> readAll() {
        return (List<Actions>) actionsDao.findAll();
    }

    @Override
    public Actions readById (String id) {
        Optional<Actions> optionalActions = actionsDao.findById(Integer.parseInt(id));

        if (!optionalActions.isPresent()){
            throw new ResourcePersistenceException("the action id: " + id + " is not present.");
        }
        return optionalActions.get();
    }

    @Override
    public Actions update (Actions updatedActions) {
        return actionsDao.save(updatedActions);
    }

    public Actions update (ActionsInitalizer actionsInitalizer) {

        Actions updatedActions = new Actions();
        UserProfile userProfile = userProfileDao.findById(actionsInitalizer.getUsername()).get();
        Contents contents = contentsDao.findById(actionsInitalizer.getContentsid()).get();

        updatedActions.setId(actionsInitalizer.getId());
        updatedActions.setUsername(userProfile);
        updatedActions.setContentsid(contents);
        updatedActions.setUsercomment(actionsInitalizer.getUsercomment());
        updatedActions.setUserlike(actionsInitalizer.getUserlike());
        updatedActions.setUsercomment(actionsInitalizer.getUsercomment());
        updatedActions.setUserstatus(actionsInitalizer.getUserstatus());

         return actionsDao.save(updatedActions);
    }

    @Override
    public boolean delete (String id) {
        actionsDao.deleteById(Integer.parseInt(id));
        return true;
    }

    @Override
    public boolean validateInput(Actions object) {
        return false;
    }

    public List<Actions> selectAllActionsByContentsId(String contentsid){

        if(contentsid == null || contentsid.trim().equals("")) {
            throw new InvalidRequestException("contents id is an invalid entry. Please select the contents id you want to read.");
        }
        Contents contents = contentsDao.findById(Integer.parseInt(contentsid)).get();
        List<Actions> actionsListByContentsId = (List<Actions>) actionsDao.selectAllActionsByContentsId(contents);

        return actionsListByContentsId;

    }

}
