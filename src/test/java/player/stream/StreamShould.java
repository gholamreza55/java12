package player.stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import player.Player;
import player.PlayerTestPlayer;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamShould {
    @Test
    void have_many_collector() {
        PlayerTestPlayer scorers = new PlayerTestPlayer();
        List<String> result = scorers.getPlayers().stream()
                .collect(teeing(
                        mapping(Player::getGoal, averagingDouble(goal -> goal)),
                        mapping(Player -> Player.toString(), toSet()),
                        (average, playInfo) -> playInfo.stream()
                                .map(format(average)).collect(toList())
                ));
        System.out.println(result);

//        Assertions.assertThat(result).isEqualTo("[name='Mokhtar Dahari', goal=89/101.2" +
//                ", name='Ali Daei', goal=109/101.2" +
//                ", name='Cristiano Ronaldo', goal=115/101.2, name='Ferenc Puskas', goal=84/101.2]");
    }

    private Function<String, String> format(Double average) {
        return pi -> pi.replace("Player", "")
                .replace("{", "")
                .replace("}", "") + "/" + average;
    }
}
