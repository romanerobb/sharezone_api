package com.revature.sharezone.contents;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentsDao extends CrudRepository<Contents, Integer> {


}
