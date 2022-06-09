package com.revature.sharezone.tags;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagsDao extends CrudRepository<Tags, Integer> {

}
