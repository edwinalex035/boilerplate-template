package microservices.book.gamification.services;

import java.util.List;
import microservices.book.gamification.models.LeaderBoardRow;
import microservices.book.gamification.repositories.ScoreCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class LeaderBoardServiceImpl implements LeaderBoardService {

  private ScoreCardRepository scoreCardRepository;

  @Autowired
  LeaderBoardServiceImpl(ScoreCardRepository scoreCardRepository) {
    this.scoreCardRepository = scoreCardRepository;
  }

  @Override
  public List<LeaderBoardRow> getCurrentLeaderBoard() {
    return scoreCardRepository.findFirst10();
  }
}