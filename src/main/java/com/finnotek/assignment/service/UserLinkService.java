package com.finnotek.assignment.service;

import com.finnotek.assignment.domain.UserLink;
import com.finnotek.assignment.service.dto.UserLinkRequestDTO;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface UserLinkService {
    List<UserLink> getAllUserLinks(String userId, Pageable pageable);

    UserLink addNewLink(String userId, UserLinkRequestDTO dto);
}
