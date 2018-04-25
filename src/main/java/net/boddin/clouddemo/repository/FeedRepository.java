package net.boddin.clouddemo.repository;

import net.boddin.clouddemo.entity.Feed;
import org.springframework.data.repository.CrudRepository;

public interface FeedRepository extends CrudRepository<Feed, Integer> {
}
