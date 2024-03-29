package laddergame.domain.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {
    private List<Player> playersForTest;
    private Players players;

    @BeforeEach
    public void setUp() {
        playersForTest = new ArrayList<>();
        playersForTest.add(new Player("pobi"));
        playersForTest.add(new Player("crong"));
        playersForTest.add(new Player("red"));
        players = new Players(playersForTest);
    }

    @Test
    public void 객체_생성_검사() {
        assertThat(players).isEqualTo(new Players(playersForTest));
    }

    @Test
    public void 총_플레이어의_인원을_제대로_반환하는지_검사() {
        assertThat(players.getPlayersSize()).isEqualTo(3);
    }

    @Test
    public void 이름이_존재하지_않을_때() {
        assertThat(players.contains("water")).isFalse();
    }
}
