package com.finnotek.assignment.service.mapper;

import com.finnotek.assignment.config.Constants;
import com.finnotek.assignment.domain.UserLink;
import com.finnotek.assignment.service.dto.UserLinkRequestDTO;
import com.finnotek.assignment.service.dto.UserLinkResponeDTO;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.web.util.UriComponentsBuilder;

import javax.xml.crypto.Data;

@Mapper(componentModel = "spring")
public abstract class UserLinkMapper {
    public abstract UserLink toEntity(UserLinkRequestDTO dto);

    public abstract UserLinkResponeDTO toDTO(UserLink userLink);

    @AfterMapping
    public void afterMaping(@MappingTarget UserLinkResponeDTO dto) {
        var shorten = UriComponentsBuilder.fromPath(Constants.SHORTEN_LINK_SERVE_URL).pathSegment(dto.getHash()).build();
        dto.setShortened(shorten.toString());
    }
}
