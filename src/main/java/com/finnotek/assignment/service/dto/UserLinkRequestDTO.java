package com.finnotek.assignment.service.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;

public class UserLinkRequestDTO {

    @NotBlank
    private String url;

    private Date expireTime;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
