package hanabi.model;

import java.util.List;

public class Deck extends CardCollection {
    public Deck(List<Card> cards) {
        super(cards);
        shuffle();
    }

    @Override
    public boolean isFull() {
        return false; // El mazo no tiene una capacidad fija; puede reponerse.
    }

    /** Extrae la carta superior del mazo, o null si está vacío. */
    public Card dealCard() {
        if (isEmpty()) return null;
        return takeCard(cards.size() - 1);
    }
}
