package com.devopsbuddy.backend.persistence.repositories;

import com.devopsbuddy.backend.persistence.domain.backend.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sreenu on 1-11-2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long>{

    /**
     * Returns a User given by username if exists else returns null
     * @param username
     * @return
     */
    public User findByUsername(String username);
}
