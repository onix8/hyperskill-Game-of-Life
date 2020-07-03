package life;

import java.util.Random;

/**
 * The type Universe.
 */
public class Universe {
    private final int size;
    private boolean[][] universe;
    private int counterGen;

    /**
     * Instantiates a new Universe.
     *
     * @param size the size
     */
    Universe(int size) {
        this.size = size;
        this.universe = new boolean[size][size];
        counterGen = 1;
        randomFillUniverse();
    }

    /**
     * Fills the Universe randomly.
     */
    private void randomFillUniverse() {
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                universe[i][j] = random.nextBoolean();
            }
        }
    }

    /**
     * Populates a new generation into the universe.
     */
    void generateNewUniverse() {
        boolean[][] newU = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newU[i][j] = isWillLife(i, j);
            }
        }

        universe = newU;
        counterGen++;
    }

    /**
     * Determines whether the cell will live.
     *
     * @param i the line of the universe
     * @param j the column of the universe
     * @return boolean value that will live or not
     */
    private boolean isWillLife(int i, int j) {
        int n = size;
        boolean isLife = false;
        int count = 0;

        if (universe[i][(j + n - 1) % n]) {
            count++;
        }
        if (universe[i][(j + 1) % n]) {
            count++;
        }
        if (universe[(i + n - 1) % n][j]) {
            count++;
        }
        if (universe[(i + 1) % n][j]) {
            count++;
        }
        if (universe[(i + n - 1) % n][(j + n - 1) % n]) {
            count++;
        }
        if (universe[(i + 1) % n][(j + 1) % n]) {
            count++;
        }
        if (universe[(i + 1) % n][(j + n - 1) % n]) {
            count++;
        }
        if (universe[(i + n - 1) % n][(j + 1) % n]) {
            count++;
        }

        if (!universe[i][j] && count == 3) {
            isLife = true;
        }

        if (universe[i][j] && (count == 2 || count == 3)) {
            isLife = true;
        }

        return isLife;
    }

    void printStats() {
        System.out.printf("Generation #%d%n", counterGen);

        int counterO = 0;
        for (boolean[] booleans : universe) {
            for (boolean b : booleans) {
                if (b) {
                    counterO++;
                }
            }
        }
        System.out.printf("Alive: %d%n", counterO);

    }

    /**
     * Print universe.
     */
    void printUniverse() {
        for (boolean[] booleans : universe) {
            for (boolean b : booleans) {
                System.out.print(b ? 'O' : ' ');
            }
            System.out.println();
        }
    }
}
