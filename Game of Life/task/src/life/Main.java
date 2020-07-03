package life;

import java.io.IOException;
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
     * Number of generations.
     */
    static int m = 10;

    /**
     * The entry point of application.
     *
     * @param args the input arguments - not use
     */
    public static void main(String[] args) throws InterruptedException {
        userInput();
        Universe universe = new Universe(n);
        for (int i = 0; i < m; i++) {
            clearScreen();
            universe.printStats();
            universe.printUniverse();
            universe.generateNewUniverse();
            Thread.sleep(1000);
        }
    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * User input.
     */
    private static void userInput() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
    }
}
