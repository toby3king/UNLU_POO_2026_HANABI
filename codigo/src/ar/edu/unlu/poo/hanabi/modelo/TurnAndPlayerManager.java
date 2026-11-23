package hanabi.model;

import java.util.ArrayList;
import java.util.List;

public class TurnAndPlayerManager {
    private final int maxPlayers;
    private final List<Player> players;
    private Player playerInTurn;

    public TurnAndPlayerManager(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.players = new ArrayList<>();
    }

    public Player playerInTurn() {
        return playerInTurn;
    }

    public boolean addPlayer(Player player) {
        if (player == null || players.size() >= maxPlayers || players.contains(player)) {
            return false;
        }
        players.add(player);
        if (playerInTurn == null) playerInTurn = player;
        return true;
    }

    public boolean isAllPlayerConnected() {
        return players.size() == maxPlayers;
    }

    public List<IPlayer> getPlayers() {
        return new ArrayList<>(players);
    }

    public boolean isCurrentPlayer(IPlayer candidate) {
        return playerInTurn != null && playerInTurn.equals(candidate);
    }

    public void advanceTurn() {
        if (players.isEmpty()) return;
        int current = players.indexOf(playerInTurn);
        playerInTurn = players.get((current + 1) % players.size());
    }
}
