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
}
