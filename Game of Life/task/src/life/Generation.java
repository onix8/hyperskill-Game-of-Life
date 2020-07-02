package life;

/**
 * The type Generation.
 */
public class Generation {
    private final Universe universe;
    private final Universe newUniverse;

    /**
     * Instantiates a new Generation.
     *
     * @param universe the universe
     */
    Generation(Universe universe) {
        this.universe = universe;
        this.newUniverse = new Universe();
        generateNewUniverse();
    }

    /**
     * Populates a new generation into the universe.
     */
    private void generateNewUniverse() {
        char[][] oldU = universe.getUniverse();
        int n = oldU.length;
        char[][] newU = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newU[i][j] = isWillLife(oldU, i, j) ? 'O' : ' ';
            }
        }

        newUniverse.setUniverse(newU);
    }

    /**
     * Determines whether the cell will live.
     *
     * @param u universe
     * @param i the line of the universe
     * @param j the column of the universe
     * @return boolean value that will live or not
     */
    private boolean isWillLife(char[][] u, int i, int j) {
        int n = u.length;
        boolean isLife = false;
        int count = 0;

        count += u[i][(j + n - 1) % n] == 'O' ? 1 : 0;
        count += u[i][(j + 1) % n] == 'O' ? 1 : 0;

        count += u[(i + n - 1) % n][j] == 'O' ? 1 : 0;
        count += u[(i + 1) % n][j] == 'O' ? 1 : 0;

        count += u[(i + n - 1) % n][(j + n - 1) % n] == 'O' ? 1 : 0;
        count += u[(i + 1) % n][(j + 1) % n] == 'O' ? 1 : 0;

        count += u[(i + 1) % n][(j + n - 1) % n] == 'O' ? 1 : 0;
        count += u[(i + n - 1) % n][(j + 1) % n] == 'O' ? 1 : 0;

        if (u[i][j] == ' ' && count == 3) {
            isLife = true;
        }

        if (u[i][j] == 'O' && (count == 2 || count == 3)) {
            isLife = true;
        }

        return isLife;
    }

    /**
     * Gets new universe.
     *
     * @return the new universe
     */
    Universe getNewUniverse() {
        return newUniverse;
    }
}
