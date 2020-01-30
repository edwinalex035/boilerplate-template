package microservices.book.multiplication.controllers;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import microservices.book.multiplication.models.MultiplicationResultAttempt;
import microservices.book.multiplication.services.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/results")
final class MultiplicationResultAttemptController {

  private final MultiplicationService multiplicationService;

  @Autowired
  MultiplicationResultAttemptController(final MultiplicationService multiplicationService) {
    this.multiplicationService = multiplicationService;
  }

  @GetMapping
  ResponseEntity<List<MultiplicationResultAttempt>> getStatistics(
      @RequestParam("alias") String alias) {
    return ResponseEntity.ok(multiplicationService.getStatsForUser(alias));
  }

  @PostMapping
  ResponseEntity<MultiplicationResultAttempt> postResult(
      @RequestBody MultiplicationResultAttempt multiplicationResultAttempt) {
    boolean isCorrect = multiplicationService.checkAttempt(multiplicationResultAttempt);
    MultiplicationResultAttempt attemptCopy = new MultiplicationResultAttempt(
        multiplicationResultAttempt.getUser(),
        multiplicationResultAttempt.getMultiplication(),
        multiplicationResultAttempt.getResultAttempt(),
        isCorrect
    );
    return ResponseEntity.ok(attemptCopy);
  }

  @RequiredArgsConstructor
  @NoArgsConstructor(force = true)
  @Getter
  public static final class ResultResponse {

    private final boolean correct;
  }
}