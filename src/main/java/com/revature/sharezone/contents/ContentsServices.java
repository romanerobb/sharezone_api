package com.revature.sharezone.contents;

import com.revature.sharezone.actions.Actions;
import com.revature.sharezone.userprofile.UserProfile;
import com.revature.sharezone.userprofile.UserProfileDao;
import com.revature.sharezone.util.exceptions.AuthenticationException;
import com.revature.sharezone.util.exceptions.InvalidRequestException;
import com.revature.sharezone.util.exceptions.ResourcePersistenceException;
import com.revature.sharezone.util.interfaces.Serviceable;
import com.revature.sharezone.util.web.dto.ActionsInitalizer;
import com.revature.sharezone.util.web.dto.ContentsInitializer;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContentsServices implements Serviceable<Contents> {

    private final ContentsDao contentsDao;
    private final UserProfileDao userProfileDao;


    @Autowired
    public ContentsServices(ContentsDao contentsDao, UserProfileDao userProfileDao) {
        this.contentsDao = contentsDao;
        this.userProfileDao = userProfileDao;
    }

    @Override
    public Contents create(Contents newContents) {
        return contentsDao.save(newContents);
    }


    public Contents create (ContentsInitializer contentsInitializer) {
        Contents newContents = new Contents();
        UserProfile userProfile = userProfileDao.findById(contentsInitializer.getUsername()).get();

        newContents.setDisplaypicture(contentsInitializer.getDisplaypicture());
        newContents.setPostcontent(contentsInitializer.getPostcontent());
        newContents.setSection(contentsInitializer.getSection());
        newContents.setPostdate(contentsInitializer.getPostdate());
        newContents.setUsername(userProfile);

        return contentsDao.save(newContents);
    }

    @Override
    public List<Contents> readAll() {
        return (List<Contents>) contentsDao.findAll();
    }

    @Override
    public Contents readById(String id) {
        Optional<Contents> optionalContents = contentsDao.findById(Integer.parseInt(id));

        if (!optionalContents.isPresent()){
            throw new ResourcePersistenceException("the content id: " + id + " is not present.");
        }
        return optionalContents.get();
    }

    @Override
    public Contents update(Contents updateContent) {
        return contentsDao.save(updateContent);
    }

    public Contents update (@NotNull ContentsInitializer contentsInitializer) {

        Contents updatedContents = new Contents();
        UserProfile userProfile = userProfileDao.findById(contentsInitializer.getUsername()).get();

        updatedContents.setDisplaypicture(contentsInitializer.getDisplaypicture());
        updatedContents.setPostcontent(contentsInitializer.getPostcontent());
        updatedContents.setSection(contentsInitializer.getSection());
        updatedContents.setPostdate(contentsInitializer.getPostdate());
        updatedContents.setUsername(userProfile);

        return contentsDao.save(updatedContents);
    }

    @Override
    public boolean delete(String id) {
        contentsDao.deleteById(Integer.parseInt(id));
        return true;
    }

    @Override
    public boolean validateInput(Contents contents) {
        if (contents == null)  return false;
        if(contents.getSection() == null || contents.getSection().trim().equals("") ) return false;
        if(contents.getPostdate() == null || contents.getPostdate().trim().equals("")) contents.setPostdate(LocalDate.now().toString() );
        return true;
    }

    public List<Contents> selectAllContentsBySection(String section){

        if(section == null || section.trim().equals("")) {
            throw new InvalidRequestException("section is an invalid entry. Please select the section you want to read.");
        }
        List<Contents> contentsListBySection = (List<Contents>) contentsDao.selectAllContentsBySection(section);
        return contentsListBySection;

    }
}