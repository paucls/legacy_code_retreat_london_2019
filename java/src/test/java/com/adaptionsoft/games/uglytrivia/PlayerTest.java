package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class PlayerTest {
    @Test
    public void should_add_a_coin_to_player() {
        Player player = new Player("John");

        player.addOneCoin();

        assertEquals(1, player.coins());
    }

    @Test
    public void should_win_when_has_6_coins() {
        Player player = new Player("John");

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
        Player player = new Player("John");

        player.move(2);

        assertThat(player.place(), is(2));
    }

    @Test
    public void should_wrap_when_moving_beyond_12() {
        Player player = new Player("John");
        player.move(2);

        player.move(6);
        player.move(6);

        assertThat(player.place(), is(2));
    }

    @Test
    public void should_go_to_penalty_box() {
        Player player = new Player("John");

        player.goToPenaltyBox();

        assertThat(player.inPenaltyBox(), is(true));
    }
}
