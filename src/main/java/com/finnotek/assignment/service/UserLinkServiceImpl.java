package com.finnotek.assignment.service;

import com.finnotek.assignment.domain.UserLink;
import com.finnotek.assignment.repository.user_link.UserLinkRepository;
import com.finnotek.assignment.service.dto.UserLinkRequestDTO;

import java.util.List;

import com.finnotek.assignment.service.mapper.UserLinkMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserLinkServiceImpl implements UserLinkService {

    private final UserLinkRepository userLinkRepository;

    private final UserLinkMapper userLinkMapper;

    public UserLinkServiceImpl(UserLinkRepository userLinkRepository, UserLinkMapper userLinkMapper) {
        this.userLinkRepository = userLinkRepository;
        this.userLinkMapper = userLinkMapper;
    }

    @Override
    public List<UserLink> getAllUserLinks(String userId, Pageable pageable) {
        return userLinkRepository.findAllByUserId(userId, pageable).getContent();
    }

    @Override
    public UserLink addNewLink(String userId, UserLinkRequestDTO dto) {
        var link = userLinkMapper.toEntity(dto);
        link.setHash("1");
        link.setUserId("1");
        userLinkRepository.save(link);
        return link;
    }
}
