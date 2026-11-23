package hanabi.model;

public class DiscardStack extends CardCollection {
    public DiscardStack() {
        super();
    }

    public Card showTopCard() {
        if (isEmpty()) return null;
        return viewCard(cards.size() - 1);
    }

    @Override
    public boolean isFull() {
        return false;
    }
}
