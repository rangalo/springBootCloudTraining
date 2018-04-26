package net.boddin.clouddemo.service;

import net.boddin.clouddemo.entity.Post;
import net.boddin.clouddemo.entity.User;
import net.boddin.clouddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {

        userRepository.save(user);
    }

    public List<User> findAll() {

        List<User> allUsers = new ArrayList<>();
        userRepository.findAll().forEach(allUsers::add);
        return allUsers;
    }

    public void addPost(Long id, Post post) {

        User byId = userRepository.findById(id);

        List<Post> posts = byId.getPosts();

        posts.add(post);

        byId.setPosts(posts);
    }

    public List<Post> getPostsForUser(Long id) {

        User byId = userRepository.findById(id);

        return byId.getPosts();
    }

    public void addFollowing(Long followerId, Long followingId) {

        User follower = userRepository.findById(followerId);

        User following = userRepository.findById(followingId);

        List<User> followings = follower.getFollowings();

        followings.add(following);

        follower.setFollowings(followings);
    }
}
