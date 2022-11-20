package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PlayerTest {
    @Test
    public void movable_다리_시작점에서_움직일_수_있는지() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        assertThat(player.movable()).isTrue();
    }

    @Test
    public void movable_다리_끝에서_움직일수_있는지() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        player.move("U");
        player.move("U");

        assertThat(player.movable()).isFalse();
    }

    @Test
    public void movable_move실패시_움직일수_있는지() throws Exception {
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        player.move("U");
        player.move("D");

        assertThat(player.movable()).isFalse();
    }

    @Test
    public void move_다리_시작점에서_움직임이_성공인지_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        assertThat(player.move("U")).isEqualTo(0);
    }

    @Test
    public void move_다리_끝점에서_움직임이_실패인지_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        player.move("U");
        player.move("U");
        assertThat(player.move("U")).isEqualTo(1);
    }

    @Test
    public void 다리_끝까지_온_플레이어가_성공인지_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        //when
        player.move("U");
        player.move("U");

        //then
        assertThat(player.isSuccess()).isTrue();
    }

    @Test
    public void 다리_중간의_플레이어가_성공인지_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        //when
        player.move("U");

        //then
        assertThat(player.isSuccess()).isFalse();
    }

    @Test
    public void 다리_중간에서_move_실패한_플레이어가_성공인지_반환() throws Exception {
        //given
        Player player = new Player(new Bridge(List.of("U", "U")));
        player.startRound();

        //when
        player.move("U");
        player.move("D");

        //then
        assertThat(player.isSuccess()).isFalse();
    }
}