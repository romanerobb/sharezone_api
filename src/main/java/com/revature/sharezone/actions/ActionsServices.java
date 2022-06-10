package com.revature.sharezone.actions;

import com.revature.sharezone.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
<<<<<<< HEAD
=======

>>>>>>> cb8209170281249ccb6d6b190901c1418f8687f5
public class ActionsServices implements Serviceable<Actions> {

    private final ActionsDao actionsDao;

    @Autowired
    public ActionsServices(ActionsDao actionsDao) {
        this.actionsDao = actionsDao;
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

}
