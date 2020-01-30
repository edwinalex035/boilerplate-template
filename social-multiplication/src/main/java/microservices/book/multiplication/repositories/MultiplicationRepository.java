package microservices.book.multiplication.repositories;

import java.util.Optional;
import microservices.book.multiplication.models.Multiplication;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface allows us to save and retrieve Multiplications
 */
public interface MultiplicationRepository extends CrudRepository<Multiplication, Long> {

  Optional<Multiplication> findByFactorAAndFactorB(final int factorA, final int factorB);

}