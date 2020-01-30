package microservices.book.multiplication.services;

import java.util.Optional;
import microservices.book.multiplication.models.Multiplication;
import microservices.book.multiplication.models.MultiplicationResultAttempt;
import microservices.book.multiplication.models.User;
import microservices.book.multiplication.repositories.MultiplicationRepository;
import microservices.book.multiplication.repositories.MultiplicationResultAttemptRepository;
import microservices.book.multiplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
class MultiplicationServiceImpl implements MultiplicationService {

  private RandomGeneratorService randomGeneratorService;
  private MultiplicationResultAttemptRepository attemptRepository;
  private MultiplicationRepository multiplicationRepository;
  private UserRepository userRepository;

  @Autowired
  public MultiplicationServiceImpl(final RandomGeneratorService randomGeneratorService,
      final MultiplicationResultAttemptRepository attemptRepository,
      final MultiplicationRepository multiplicationRepository,
      final UserRepository userRepository) {
    this.randomGeneratorService = randomGeneratorService;
    this.attemptRepository = attemptRepository;
    this.multiplicationRepository = multiplicationRepository;
    this.userRepository = userRepository;
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
  public boolean checkAttempt(final MultiplicationResultAttempt attempt) {
    // check if the user already exists for that alias
    Optional<User> user = userRepository.findByAlias(attempt.getUser().getAlias());

    // check if the multiplication alread exists for the factors
    Optional<Multiplication> multiplication = multiplicationRepository.findByFactorAAndFactorB(
        attempt.getMultiplication().getFactorA(),
        attempt.getMultiplication().getFactorB()
    );

    // Avoids 'hack' attempts
    Assert.isTrue(!attempt.isCorrect(),
        "You can't send an attempt marked as correct!!");

    // Checks if it's correct
    boolean correct = attempt.getResultAttempt() ==
        attempt.getMultiplication().getFactorA() *
            attempt.getMultiplication().getFactorB();

    // Creates a copy, now setting the 'correct' field accordingly
    MultiplicationResultAttempt checkedAttempt =
        new MultiplicationResultAttempt(user.orElse(attempt.getUser()),
            multiplication.orElse(attempt.getMultiplication()),
            attempt.getResultAttempt(),
            correct);

    // store the attempt
    attemptRepository.save(checkedAttempt);

    // Returns the result
    return correct;
  }
}