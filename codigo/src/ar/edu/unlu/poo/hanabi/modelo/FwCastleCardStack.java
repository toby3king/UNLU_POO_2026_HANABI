package hanabi.model;

public class FwCastleCardStack extends CardCollection {
    private final Color fwColor;

    public FwCastleCardStack(Color color) {
        super();
        this.fwColor = color;
    }

    public Color getFwColor() {
        return fwColor;
    }

    public boolean isPlayable(Card card) {
        if (card == null || card.getFwColor() != fwColor) return false;
        return card.getFwLevel() == size() + 1;
    }

    /** Añade la carta si respeta el orden del fuego artificial. */
    public boolean playCard(Card card) {
        if (!isPlayable(card) || isFull()) return false;
        return putCard(card);
    }

    @Override
    public boolean isFull() {
        return size() >= 5;
    }
}
