package com.revature.sharezone.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;
import java.util.List;

@Service
@Transactional

public class ActionsServices implements Servicable<Actions> {

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
