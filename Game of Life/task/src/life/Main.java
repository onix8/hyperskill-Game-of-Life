package life;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long s = sc.nextLong();
        char[][] universe = new char[n][n];
        Random random = new Random(s);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                universe[i][j] = random.nextBoolean() ? 'O' : ' ';

            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(universe[i][j]);
            }
            System.out.println();
        }
    }
}
