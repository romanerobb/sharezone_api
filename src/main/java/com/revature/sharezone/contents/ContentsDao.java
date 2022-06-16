package com.revature.sharezone.contents;

import com.revature.sharezone.userprofile.UserProfile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentsDao extends CrudRepository<Contents, Integer> {

    @Query(value = "FROM Contents WHERE section= :section ORDER BY  id desc")
    List<Contents> selectAllContentsBySection(String section);
}
