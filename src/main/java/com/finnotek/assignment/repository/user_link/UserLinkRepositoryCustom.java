package com.finnotek.assignment.repository.user_link;

import com.finnotek.assignment.domain.UserLink;

import java.util.Optional;

public interface UserLinkRepositoryCustom {
    Optional<UserLink> findUnexpiredLinkByHash(String hash);
}
