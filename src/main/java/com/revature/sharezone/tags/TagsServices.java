package com.revature.sharezone.tags;

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

    @Autowired
    public TagsServices(TagsDao tagsDao) {
        this.tagsDao = tagsDao;
    }


    @Override
    public Tags create(Tags newObject) {
        return null;
    }

    @Override
    public List<Tags> readAll() throws IOException {
        return null;
    }

    @Override
    public Tags readById(String id) {
        return null;
    }

    @Override
    public Tags update(Tags updatedObject) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean validateInput(Tags object) {
        return false;
    }
}
