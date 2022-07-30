package com.finnotek.assignment.domain;

import com.finnotek.assignment.config.Constants;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document(Constants.USER_LINK_MONGO_COLLECTION_NAME)
public class UserLink implements Serializable {

    private String id;

    @Indexed(unique = true)
    private String hash;
    private String url;
    private String userId;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
