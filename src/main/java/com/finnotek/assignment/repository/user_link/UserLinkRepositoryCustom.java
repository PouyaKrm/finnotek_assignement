package com.finnotek.assignment.repository.user_link;

import com.finnotek.assignment.domain.UserLink;

import java.util.Optional;

public interface UserLinkRepositoryCustom {
    UserLink findUnexpiredLinkByHash(String hash);
}
