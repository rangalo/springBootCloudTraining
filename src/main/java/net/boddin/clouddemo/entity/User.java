package net.boddin.clouddemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -2426538032823398804L;

    private String firstName;

    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Post> posts;

    @ManyToMany
    @JoinTable(name="feeds", joinColumns =
            {@JoinColumn(name = "follower_id", referencedColumnName = "id", nullable = false)},
            inverseJoinColumns = { @JoinColumn(name = "following_id", referencedColumnName = "id", nullable = false)})
    @JsonIgnore
    private List<User> followings;

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {

        if (null == this.posts) {

            return new ArrayList<>();
        }

        return this.posts;
    }

    public void setPosts(List<Post> posts) {

        if (null == posts) {

            this.posts = new ArrayList<>();
        } else  {

            this.posts = posts;
        }
    }

    public List<User> getFollowings() {

        if (null == this.followings) {

            return new ArrayList<>();
        }
        return this.followings;
    }

    public void setFollowings(List<User> followings) {

        if (null == followings) {

            this.followings = new ArrayList<>();
        } else {

            this.followings = followings;
        }
    }
}
