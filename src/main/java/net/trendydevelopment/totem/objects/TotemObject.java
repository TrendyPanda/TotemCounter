package net.trendydevelopment.totem.objects;

import org.bukkit.entity.Player;

public class TotemObject {
    Player player1;
    Player player2;
    int player1totems;
    int player2totems;
    public TotemObject(Player player1, Player player2, int player1totems, int player2totems) {
        this.player1 = player1;
        this.player2 = player2;
        this.player1totems = player1totems;
        this.player2totems = player2totems;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public int getPlayer2totems() {
        return player2totems;
    }

    public int getPlayer1totems() {
        return player1totems;
    }

    public void addPlayer1Totem() {
        player1totems++;
    }

    public void addPlayer2Totem() {
        player2totems++;
    }
}
