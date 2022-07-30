package com.finnotek.assignment.web.rest;

import com.finnotek.assignment.service.UserLinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpResponse;

@RestController
@RequestMapping("")
public class LinkResource {

    private final UserLinkService userLinkService;

    public LinkResource(UserLinkService userLinkService) {
        this.userLinkService = userLinkService;
    }

    @GetMapping("{linkHash}")
    public ResponseEntity<Object> redirect(@PathVariable String linkHash) {
        var link = userLinkService.findLinkByHash(linkHash);
        if(link.isPresent()) {
            return ResponseEntity.status(HttpStatus.TEMPORARY_REDIRECT).location(URI.create(link.get().getUrl())).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("link does not exist or expired");
        }
    }
}
