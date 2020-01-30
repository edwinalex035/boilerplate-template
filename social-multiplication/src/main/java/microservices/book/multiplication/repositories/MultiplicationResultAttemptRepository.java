package microservices.book.multiplication.repositories;

import java.util.List;
import microservices.book.multiplication.models.MultiplicationResultAttempt;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface allow us to store and retrieve attempts
 */
public interface MultiplicationResultAttemptRepository extends
    CrudRepository<MultiplicationResultAttempt, Long> {

  /**
   * @return the latest 5 attempts for a given user, identified by their alias.
   */
  List<MultiplicationResultAttempt> findTop5ByUserAliasOrderByIdDesc(String userAlias);
}
