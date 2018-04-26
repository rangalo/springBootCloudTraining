package net.boddin.clouddemo.repository;

import net.boddin.clouddemo.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
