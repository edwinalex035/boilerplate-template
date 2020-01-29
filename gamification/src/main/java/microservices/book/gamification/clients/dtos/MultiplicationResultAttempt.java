package microservices.book.gamification.clients.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import microservices.book.gamification.clients.MultiplicationResultAttemptDeserializer;

/**
 * Identifies the attempt from a user to solve a multiplication.
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@JsonDeserialize(using = MultiplicationResultAttemptDeserializer.class)
public class MultiplicationResultAttempt {
  private final String userAlias;
  private final int multiplicationFactorA;
  private final int multiplicationFactorB;
  private final int resultAttempt;
  private final boolean correct;

  // Empty constructor for JSON/JPA
  MultiplicationResultAttempt() {
    userAlias = null;
    multiplicationFactorA = -1;
    multiplicationFactorB = -1;
    resultAttempt = -1;
    correct = false;
  }
}
