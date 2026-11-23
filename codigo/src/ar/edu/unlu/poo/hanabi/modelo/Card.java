package hanabi.model;

import java.util.Objects;

public class Card implements ICard {
    private final Integer fireworkLevel;
    private final Color fireworkColor;

    public Card(Integer fwLevel, Color fwColor) {
        this.fireworkLevel = Objects.requireNonNull(fwLevel, "fwLevel");
        this.fireworkColor = Objects.requireNonNull(fwColor, "fwColor");
    }

    @Override
    public Color getFwColor() {
        return fireworkColor;
    }

    @Override
    public Integer getFwLevel() {
        return fireworkLevel;
    }

    /** Igualdad por valor: nivel y color. */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Card other)) return false;
        return Objects.equals(fireworkLevel, other.fireworkLevel)
                && fireworkColor == other.fireworkColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fireworkLevel, fireworkColor);
    }

    @Override
    public String toString() {
        return fireworkColor + " " + fireworkLevel;
    }
}
