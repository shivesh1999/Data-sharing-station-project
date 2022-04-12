package com.project.Repository;

import com.project.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User, Long> {
    @Query("db.collection.find().limit(10);" )
    static List<User> getTopUsersDetails() {
        return null;
    }

    User findByEmail(String email);
}
