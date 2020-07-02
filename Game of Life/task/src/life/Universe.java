package life;

import java.util.Random;

/**
 * The type Universe.
 */
public class Universe {
    private char[][] universe;

    /**
     * Instantiates a new Universe.
     *
     * @param size the size
     * @param seed the seed
     */
    Universe(int size, long seed) {
        this.universe = new char[size][size];
        randomFillUniverse(seed);
    }

    /**
     * Creates an empty new Universe.
     */
    Universe() {
        this.universe = new char[0][0];
    }

    /**
     * Fills the Universe randomly, depending on the seed.
     *
     * @param seed for random value
     */
    private void randomFillUniverse(long seed) {
        Random random = new Random(seed);
        int n = universe.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                universe[i][j] = random.nextBoolean() ? 'O' : ' ';
            }
        }
    }

    /**
     * Print universe.
     */
    void printUniverse() {
        for (char[] chars : universe) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    /**
     * Get universe char [ ] [ ].
     *
     * @return the char [ ] [ ]
     */
    char[][] getUniverse() {
        return universe;
    }

    /**
     * Sets universe.
     *
     * @param universe the universe
     */
    void setUniverse(char[][] universe) {
        this.universe = universe;
    }
}
