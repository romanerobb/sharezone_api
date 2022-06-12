package com.revature.sharezone.actions;

import com.revature.sharezone.contents.Contents;
import com.revature.sharezone.contents.ContentsDao;
import com.revature.sharezone.util.exceptions.InvalidRequestException;
import com.revature.sharezone.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
@Transactional
public class ActionsServices implements Serviceable<Actions> {

    private final ActionsDao actionsDao;
    private final ContentsDao contentsDao;

    @Autowired
    public ActionsServices(ActionsDao actionsDao, ContentsDao contentsDao) {
        this.actionsDao = actionsDao;
        this.contentsDao = contentsDao;
    }




    @Override
    public Actions create (Actions newActions) {
        return actionsDao.save(newActions);
    }

    @Override
    public List<Actions> readAll() {
        return (List<Actions>) actionsDao.findAll();
    }

    @Override
    public Actions readById (String id) {
        return actionsDao.findById(Integer.parseInt(id)).get();
    }

    @Override
    public Actions update (Actions updatedActions) {
        return actionsDao.save(updatedActions);
    }

    @Override
    public boolean delete (String id) {
        return false;
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
