package com.finnotek.assignment.repository.user_link;

import com.finnotek.assignment.config.Constants;
import com.finnotek.assignment.domain.User;
import com.finnotek.assignment.domain.UserLink;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public class UserLinkRepositoryCustomImpl implements UserLinkRepositoryCustom {

    private final MongoTemplate mongoTemplate;
    public static final String HASH = "hash", EXPIRE_DATE = "expireDate";

    public UserLinkRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    @Cacheable("links")
    public UserLink findUnexpiredLinkByHash(String hash) {
        var matchCriteria = Criteria.where(HASH).is(hash).and(EXPIRE_DATE).is(null);
        var or = new Criteria();
        or.orOperator(Criteria.where(EXPIRE_DATE).is(null), Criteria.where(EXPIRE_DATE).gt(new Date()));
        matchCriteria.andOperator(or);
        var q = new Query(matchCriteria);
        var result = mongoTemplate.findOne(q, UserLink.class, Constants.USER_LINK_MONGO_COLLECTION_NAME);
        return result;
    }

}
