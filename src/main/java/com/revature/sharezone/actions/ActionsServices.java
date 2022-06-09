package com.revature.sharezone.actions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class ActionsServices implements Servicable<Actions> {

    private final ActionsDao actionsDao;
    private final TagsDao tagsDao;

    @Autowired
    public ActionsServices(TagsDao tagsDao, ActionsDao actionsDao) {
        this.actionsDao = actionsDao;
        this.tagsDao = tagsDao;
    }

    @Override
    public Actions create (Actions newActions) {
        return actionsDao.save(newActions);
    }

    @Override
    public List<Actions> readAll() {
        return (List)
    }

}
