package hanabi.model;

public class PlayerHand extends CardCollection {
    private static final int MAX_CARDS = 5;

    public PlayerHand() {
        super();
    }

    @Override
    public boolean isFull() {
        return size() >= MAX_CARDS;
    }

    /** Extrae una carta de la mano por índice. */
    public Card takeCard(int index) {
        return super.takeCard(index);
    }
}
