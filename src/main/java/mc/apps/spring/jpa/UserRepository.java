package mc.apps.spring.jpa;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Integer> {
    List<User> findByLastName(String lastname);
}
