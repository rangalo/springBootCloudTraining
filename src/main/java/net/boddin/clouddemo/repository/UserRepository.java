package net.boddin.clouddemo.repository;

import net.boddin.clouddemo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findById(Long id);
}
