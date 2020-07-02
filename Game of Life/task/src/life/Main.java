package life;

import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    /**
     * Size of a two-dimensional array NxN.
     */
    static int n;
    /**
     * Seed for random value.
     */
    static long s;
    /**
     * Number of generations.
     */
    static int m;

    /**
     * The entry point of application.
     *
     * @param args the input arguments - not use
     */
    public static void main(String[] args) {
        userInput();
        Universe universe = new Universe(n, s);
        for (int i = 0; i < m; i++) {
            universe = new Generation(universe).getNewUniverse();
        }
        universe.printUniverse();
    }

    /**
     * User input.
     */
    private static void userInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextLong();
        m = sc.nextInt();
    }
}
