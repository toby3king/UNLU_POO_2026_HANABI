package hanabi.model;

/** Administra errores y pistas disponibles. */
public class MisstakeAndClueManager {
    private int issues;
    private int availableClues;

    public MisstakeAndClueManager() {
        this.issues = 0;
        this.availableClues = 8;
    }

    public boolean addMisstake() {
        issues++;
        return issues <= 3;
    }

    public boolean addClue() {
        if (availableClues >= 8) return false;
        availableClues++;
        return true;
    }

    public void useClue() {
        if (availableClues > 0) availableClues--;
    }

    public boolean isAvailableClue() {
        return availableClues > 0;
    }

    public boolean isAllUnusedClue() {
        return availableClues >= 8;
    }

    public int getIssues() {
        return issues;
    }

    public int getAvailableClues() {
        return availableClues;
    }
}
