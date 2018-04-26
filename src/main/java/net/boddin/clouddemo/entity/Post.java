package net.boddin.clouddemo.entity;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Post extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 5013436410486318526L;

    private String text;

    public Post() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
