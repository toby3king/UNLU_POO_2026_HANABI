package hanabi.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Player implements IPlayer {
    private static final AtomicInteger NEXT_ID = new AtomicInteger(1);

    private final int playerId;
    private final PlayerHand hand;
    private final String name;
    private final int age;

    public Player(int age, String name) {
        this.playerId = NEXT_ID.getAndIncrement();
        this.hand = new PlayerHand();
        this.name = name;
        this.age = age;
    }

    public boolean giveCard(Card card) {
        return hand.putCard(card);
    }

    public Card removeCard(int index) {
        return hand.takeCard(index);
    }

    /** Comprueba igualdad por valor según Card.equals(). */
    public boolean inHand(ICard card) {
        if (!(card instanceof Card concreteCard)) return false;
        for (int i = 0; i < hand.size(); i++) {
            if (hand.viewCard(i).equals(concreteCard)) return true;
        }
        return false;
    }

    public int remainingCards() {
        return hand.size();
    }

    public PlayerHand getHand() {
        return hand;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getId() {
        return playerId;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Player other)) return false;
        return playerId == other.playerId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(playerId);
    }
}
