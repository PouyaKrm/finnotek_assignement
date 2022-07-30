package com.finnotek.assignment.service;

import com.finnotek.assignment.domain.UserLink;
import com.finnotek.assignment.repository.user_link.UserLinkRepository;
import com.finnotek.assignment.service.dto.UserLinkRequestDTO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.finnotek.assignment.service.dto.UserLinkResponeDTO;
import com.finnotek.assignment.service.mapper.UserLinkMapper;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;

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
    public UserLinkResponeDTO addNewLink(String userId, UserLinkRequestDTO dto) {
        UserLink link = userLinkMapper.toEntity(dto);
        var dateFromatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        var dateString = dateFromatter.format(new Date());
        var rawString = MessageFormat.format("{0},{1},{2}", dto.getUrl(), userId, dateString);
        try {
            var digest = MessageDigest.getInstance("SHA-256");
            var bytes = digest.digest(rawString.getBytes(StandardCharsets.UTF_8));
            var hex = new String(Hex.encode(Arrays.copyOf(bytes, 8)));
            System.out.println(hex.length());
            link.setHash(hex);
            link.setUserId(userId);
            userLinkRepository.save(link);
            return userLinkMapper.toDTO(link);
        } catch (NoSuchAlgorithmException e) {
            throw Problem.builder().withStatus(Status.INTERNAL_SERVER_ERROR).withDetail("Internal error").build();
        }
    }
}
