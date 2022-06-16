package com.revature.sharezone.actions;

import com.revature.sharezone.contents.Contents;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActionsDao extends CrudRepository<Actions, Integer> {

    @Query(value = "FROM Actions WHERE contentsid = :contents ORDER BY  id")
    Iterable<Actions> selectAllActionsByContentsId(Contents contents);
}