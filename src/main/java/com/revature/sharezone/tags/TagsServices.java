package com.revature.sharezone.tags;

import com.revature.sharezone.util.exceptions.ResourcePersistenceException;
import com.revature.sharezone.util.interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class TagsServices implements Serviceable<Tags> {

    private final TagsDao tagsDao;

    private final UserProfile userProfile;

    @Autowired
    public TagsServices(TagsDao tagsDao, UserProfile userProfile) {
        this.tagsDao = tagsDao;
        this.userProfile = userProfile;
    }

    @Override
    public Tags create(Tags newObject) {
        return tagsDao.save(newObject);
    }

    @Override
    public List<Tags> readAll() {
        List<Tags> tagsList = (List<Tags>) tagsDao.findAll();
        return tagsList;
    }

    @Override
    public Tags readById(String id) throws ResourcePersistenceException {
        Tags tags = tagsDao.findById(Integer.parseInt(id)).get();
    }

    @Override
    public Tags update(Tags updatedObject) {
        tagsDao.save(updatedObject);
        return updatedObject;
    }

    @Override
    public boolean delete(String id) {
        tagsDao.deleteById(Integer.parseInt(id));
        return true;
    }

    @Override
    public boolean validateInput(Tags newTags) {
        if(newTags == null) return false;
    }
}
