package com.finnotek.assignment.web.rest;

import com.finnotek.assignment.domain.UserLink;
import com.finnotek.assignment.security.SecurityUtils;
import com.finnotek.assignment.service.UserLinkService;
import com.finnotek.assignment.service.dto.UserLinkRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("links")
public class UserLinkResource {


    private final UserLinkService userLinkService;

    public UserLinkResource(UserLinkService userLinkService) {
        this.userLinkService = userLinkService;
    }

    @PostMapping("shorten")
    public UserLink shorten(@Valid @RequestBody UserLinkRequestDTO dto, Principal principal) {
//        var user = SecurityUtils.getCurrentUserLogin().get();
//        System.out.println(user);
       return userLinkService.addNewLink("1", dto);
//        return null;
    }

}
