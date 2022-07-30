package com.finnotek.assignment.service.mapper;

import com.finnotek.assignment.domain.UserLink;
import com.finnotek.assignment.service.dto.UserLinkRequestDTO;
import com.finnotek.assignment.service.dto.UserLinkResponeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserLinkMapper  {
    UserLink toEntity(UserLinkRequestDTO dto);
    UserLinkResponeDTO toDTO(UserLink userLink);
}
