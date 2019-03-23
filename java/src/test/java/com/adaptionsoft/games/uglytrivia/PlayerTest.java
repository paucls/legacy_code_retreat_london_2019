package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    private final Player player = new Player("John");

    @Test
    public void should_add_a_coin_to_player() {
        player.addOneCoin();

        assertEquals(1, player.coins());
    }

    @Test
    public void should_win_when_has_6_coins() {
        player.addOneCoin();
        player.addOneCoin();
        player.addOneCoin();
        player.addOneCoin();
        player.addOneCoin();
        player.addOneCoin();

        assertThat(player.didPlayerWin(), is(true));
    }

    @Test
    public void should_move_as_may_spaces_as_roll() {
        player.move(2);

        assertThat(player.place(), is(2));
    }

    @Test
    public void should_wrap_when_moving_beyond_12() {
        player.move(2);

        player.move(6);
        player.move(6);

        assertThat(player.place(), is(2));
    }

    @Test
    public void should_go_to_penalty_box() {
        player.goToPenaltyBox();

        assertThat(player.inPenaltyBox(), is(true));
    }

    @Test
    public void should_lose_all_coins_when_rolling_2_times_on_a_row_a_6() {
        player.addOneCoin();
        player.move(4);

        player.move(6);
        player.move(6);

        assertThat(player.coins(), is(0));
    }
}
