package net.boddin.clouddemo.repository;

import net.boddin.clouddemo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface UserRepository  extends CrudRepository<User,Integer> {

    Collection<User> findAllByFirstNameLike(@Param("value") String value);

    User findUserByUsername(String username);

}
