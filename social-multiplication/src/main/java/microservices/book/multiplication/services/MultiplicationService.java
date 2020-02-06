package microservices.book.multiplication.services;

import java.util.List;
import microservices.book.multiplication.models.Multiplication;
import microservices.book.multiplication.models.MultiplicationResultAttempt;

public interface MultiplicationService {

  /**
   * Creates a Multiplication object with two randomly-generated factors between 11 and 99.
   *
   * @return a Multiplication object with random factors
   */
  Multiplication createRandomMultiplication();

  /**
   * @return true if the attempt matches the result of the multiplication, false otherwise.
   */
  boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

  /**
   * @param userAlias user's alias
   * @return latest 5 Multiplication attempts
   */
  public List<MultiplicationResultAttempt> getStatsForUser(String userAlias);

  public MultiplicationResultAttempt getResultById(final Long resultId);
}
