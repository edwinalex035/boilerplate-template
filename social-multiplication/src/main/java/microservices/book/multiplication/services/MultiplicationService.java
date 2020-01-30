package microservices.book.multiplication.services;

import microservices.book.multiplication.models.Multiplication;

public interface MultiplicationService {

  /**
   * Creates a Multiplication object with two randomly-generated factors between 11 and 99.
   *
   * @return a Multiplication object with random factors
   */
  Multiplication createRandomMultiplication();
}
