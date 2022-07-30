package com.finnotek.assignment.repository.user_link;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserLinkRepositoryCustomImpl implements UserLinkRepositoryCustom {

    private final MongoTemplate mongoTemplate;

    public UserLinkRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
