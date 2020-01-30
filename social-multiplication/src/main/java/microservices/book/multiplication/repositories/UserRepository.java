package microservices.book.multiplication.repositories;

import java.util.Optional;
import microservices.book.multiplication.models.User;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface allows us to save and retrieve Users
 */
public interface UserRepository extends CrudRepository<User, Long> {

  Optional<User> findByAlias(final String alias);
}