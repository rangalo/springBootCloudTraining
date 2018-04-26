package net.boddin.clouddemo.dto;

import java.io.Serializable;

public class Following implements Serializable {

    private static final long serialVersionUID = -1090930392800618719L;

    private Long followerId;

    private Long followingId;

    public Following() {
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getFollowingId() {
        return followingId;
    }

    public void setFollowingId(Long followingId) {
        this.followingId = followingId;
    }
}
