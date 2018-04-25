package net.boddin.clouddemo.dto;

public class PostCreateDto {
    private String text;
    private int feedId;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }
}
