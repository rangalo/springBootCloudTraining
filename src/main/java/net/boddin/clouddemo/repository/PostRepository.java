package net.boddin.clouddemo.repository;

import net.boddin.clouddemo.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Integer> {
}
