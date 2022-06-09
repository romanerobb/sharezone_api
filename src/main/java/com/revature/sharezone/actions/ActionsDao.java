package com.revature.sharezone.actions;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionsDao extends CrudRepository<Actions, Integer> {

}