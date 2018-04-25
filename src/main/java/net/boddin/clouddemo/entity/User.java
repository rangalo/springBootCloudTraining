package net.boddin.clouddemo.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "User_Feed",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "feed_id")}
    )
    private Collection<Feed> feeds;

    @OneToMany(mappedBy = "user")
    private Collection<Post> posts;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Collection<Feed> getFeeds() {
        return feeds;
    }

    public void setFeeds(Collection<Feed> feeds) {
        this.feeds = feeds;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }
}
