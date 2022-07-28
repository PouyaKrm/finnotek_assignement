package com.finnotek.assignment.service;

import com.finnotek.assignment.domain.UserLink;
import com.finnotek.assignment.repository.UserLinkRepository;
import com.finnotek.assignment.service.dto.UserLinkRequestDTO;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserLinkServiceImpl implements UserLinkService {

    private final UserLinkRepository userLinkRepository;

    public UserLinkServiceImpl(UserLinkRepository userLinkRepository) {
        this.userLinkRepository = userLinkRepository;
    }

    @Override
    public List<UserLink> getAllUserLinks(String userId, Pageable pageable) {
        return userLinkRepository.findAllByUserId(userId, pageable).getContent();
    }

    @Override
    public UserLink addNewLink(String userId, UserLinkRequestDTO dto) {
        return null;
    }
}
