package microservices.book.gamification.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Collections;
import java.util.List;
import microservices.book.gamification.models.LeaderBoardRow;
import microservices.book.gamification.repositories.BadgeCardRepository;
import microservices.book.gamification.repositories.ScoreCardRepository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * @author moises.macero
 */
public class LeaderBoardServiceImplTest {
    private GameService gameService;

    private LeaderBoardService leaderBoardService;

    @Mock
    private ScoreCardRepository scoreCardRepository;

    @Mock
    private BadgeCardRepository badgeCardRepository;

    @Test
    public void retrieveLeaderBoardTest() {
        // given
        Long userId = 1L;
        LeaderBoardRow leaderRow1 = new LeaderBoardRow(userId, 300L);
        List<LeaderBoardRow> expectedLeaderBoard = Collections.singletonList(leaderRow1);
        given(scoreCardRepository.findFirst10()).willReturn(expectedLeaderBoard);

        // when
        List<LeaderBoardRow> leaderBoard = leaderBoardService.getCurrentLeaderBoard();

        // then
        assertThat(leaderBoard).isEqualTo(expectedLeaderBoard);
    }
}