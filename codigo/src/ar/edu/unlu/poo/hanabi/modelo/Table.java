package hanabi.model;

import ar.edu.unlu.poo.hanabi.common.IObservable;
import ar.edu.unlu.poo.hanabi.common.IObserver;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Table implements IObservable {
    private final Deck gameDeck;
    private final DiscardStack gameDiscard;
    private final TurnAndPlayerManager players;
    private final MisstakeAndClueManager issAndCl;
    private final Map<Color, FwCastleCardStack> fwCastles;
    private final List<IObserver> observers;

    public Table(Deck deck, int maxPlayers) {
        this.gameDeck = deck;
        this.gameDiscard = new DiscardStack();
        this.players = new TurnAndPlayerManager(maxPlayers);
        this.issAndCl = new MisstakeAndClueManager();
        this.fwCastles = new EnumMap<>(Color.class);
        for (Color color : Color.values()) {
            fwCastles.put(color, new FwCastleCardStack(color));
        }
        this.observers = new ArrayList<>();
    }

    public void playCard(IPlayer player, ICard card) {
        // TODO: validar jugador en turno, pertenencia de carta y jugabilidad.
        throw new UnsupportedOperationException("Implementar playCard");
    }

    public void useClue(IPlayer player) {
        // TODO: validar turno y disponibilidad de pistas.
        throw new UnsupportedOperationException("Implementar useClue");
    }

    public void discardCard(IPlayer player, ICard card) {
        // TODO: validar jugador y pertenencia; mover carta al descarte.
        throw new UnsupportedOperationException("Implementar discardCard");
    }

    /** Devuelve una copia de las cartas visibles, no la colección interna. */
    public List<ICard> getPlayerCards(IPlayer player) {
        // TODO: buscar jugador y construir una vista no modificable de su mano.
        throw new UnsupportedOperationException("Implementar getPlayerCards");
    }

    public int getMisstakes() {
        return issAndCl.getIssues();
    }

    public int getDeckSize() {
        return gameDeck.size();
    }

    public int getRemainingClues() {
        return issAndCl.getAvailableClues();
    }

    public ICard getFwCastle(Color color) {
        FwCastleCardStack stack = fwCastles.get(color);
        if (stack == null || stack.isEmpty()) return null;
        return stack.viewCard(stack.size() - 1);
    }

    public IPlayer addPlayer(String name, int age) {
        Player player = new Player(age, name);
        return players.addPlayer(player) ? player : null;
    }

    private EndGame gameOver() {
        // TODO: determinar el motivo del final.
        return null;
    }

    @Override
    public void addObserver(IObserver observer) {
        if (observer != null && !observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void notify(Event event) {
        for (IObserver observer : List.copyOf(observers)) {
            observer.update(event);
        }
    }
}
