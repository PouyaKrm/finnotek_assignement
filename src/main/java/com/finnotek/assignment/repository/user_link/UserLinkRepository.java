package com.finnotek.assignment.repository.user_link;

import com.finnotek.assignment.domain.UserLink;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLinkRepository extends MongoRepository<UserLink, String>, UserLinkRepositoryCustom {
    Page<UserLink> findAllByUserId(String userId, Pageable pageable);
}
