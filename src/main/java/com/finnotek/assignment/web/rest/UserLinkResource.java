package com.finnotek.assignment.web.rest;

import com.finnotek.assignment.security.AuthenticationUtils;
import com.finnotek.assignment.service.UserLinkService;
import com.finnotek.assignment.service.dto.UserLinkRequestDTO;
import com.finnotek.assignment.service.dto.UserLinkResponeDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/links")
public class UserLinkResource {


    private final UserLinkService userLinkService;
    private final AuthenticationUtils authenticationUtils;

    public UserLinkResource(UserLinkService userLinkService, AuthenticationUtils authenticationUtils) {
        this.userLinkService = userLinkService;
        this.authenticationUtils = authenticationUtils;
    }

    @PostMapping("shorten")
    public UserLinkResponeDTO shorten(@Valid @RequestBody UserLinkRequestDTO dto, Principal principal) {
        var user = authenticationUtils.getAuthenticatedUser();
        var userId = user.isPresent() ? user.get().getId() : "1";
        return userLinkService.addNewLink(userId, dto);
    }

}
