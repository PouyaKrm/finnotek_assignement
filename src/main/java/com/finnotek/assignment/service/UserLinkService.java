package com.finnotek.assignment.service;

import com.finnotek.assignment.domain.UserLink;
import com.finnotek.assignment.service.dto.UserLinkRequestDTO;
import java.util.List;
import java.util.Optional;

import com.finnotek.assignment.service.dto.UserLinkResponeDTO;
import org.springframework.data.domain.Pageable;

public interface UserLinkService {
    List<UserLink> getAllUserLinks(String userId, Pageable pageable);

    UserLinkResponeDTO addNewLink(String userId, UserLinkRequestDTO dto);

    Optional<UserLink> findLinkByHash(String hash);
}
