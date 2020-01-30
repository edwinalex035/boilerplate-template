package microservices.book.multiplication.services;

import microservices.book.multiplication.models.Multiplication;
import microservices.book.multiplication.models.MultiplicationResultAttempt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class MultiplicationServiceImpl implements
    MultiplicationService {

  private RandomGeneratorService randomGeneratorService;

  @Autowired
  public MultiplicationServiceImpl(RandomGeneratorService
      randomGeneratorService) {
    this.randomGeneratorService = randomGeneratorService;
  }

  @Override
  public Multiplication createRandomMultiplication() {
    int factorA = randomGeneratorService.
        generateRandomFactor();
    int factorB = randomGeneratorService.
        generateRandomFactor();
    return new Multiplication(factorA, factorB);
  }

  @Override
  public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {
    return false;
  }
}