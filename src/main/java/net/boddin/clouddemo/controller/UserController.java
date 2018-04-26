package net.boddin.clouddemo.controller;

import net.boddin.clouddemo.entity.Post;
import net.boddin.clouddemo.entity.User;
import net.boddin.clouddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<User>> all() {

        return ResponseEntity.ok().body(userService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody User user) {

        userService.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.POST)
    public ResponseEntity<?> createPost(@PathVariable("id") Long id, @RequestBody Post post) {

        userService.addPost(id, post);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> getPosts(@PathVariable("id") Long id) {

        List<Post> posts = userService.getPostsForUser(id);

        return ResponseEntity.ok().body(posts);
    }

}
