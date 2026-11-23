package hanabi.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Colección base de cartas. Las subclases definen su capacidad. */
public abstract class CardCollection {
    protected final List<Card> cards;

    protected CardCollection() {
        this.cards = new ArrayList<>();
    }

    protected CardCollection(List<Card> cardList) {
        this.cards = new ArrayList<>(Objects.requireNonNull(cardList, "cardList"));
    }

    protected Card takeCard(int index) {
        return cards.remove(index);
    }

    protected void shuffle() {
        Collections.shuffle(cards);
    }

    /** Devuelve una carta sin retirarla de la colección. */
    public Card viewCard(int index) {
        return cards.get(index);
    }

    /** Inserta una carta si la colección admite más cartas. */
    public boolean putCard(Card card) {
        if (card == null || isFull()) return false;
        cards.add(card);
        return true;
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public abstract boolean isFull();
}
