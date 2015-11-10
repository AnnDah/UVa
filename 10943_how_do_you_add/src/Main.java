import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by annikamagnusson on 16/10/15.
 *
 */
public class Main {
    private static BufferedReader in;
    private static int[][] grid;
    int k, n;

    public static void main (String args[]) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();

        main.start();

        in.close();
        System.exit(0);
    }

    void start() throws IOException {
        int maxN = 101;
        int maxK = 101;

        //create grid
        grid = new int[maxN][maxK];

        String line = in.readLine();

        String[] numbers = line.split(" ");

        n = Integer.parseInt(numbers[0]);
        k = Integer.parseInt(numbers[1]);

        // If line equals 0 0 then program should end
        if (n == 0 && k == 0) {
            return;
        }

        // fill grid
        for (int i = 0; i < maxN; ++i) {
            for (int j = 0; j < maxK; ++j) {
                grid[i][j] = -1;
            }
        }

        System.out.println(calc(0, n));
        start();
    }

    private int calc(int i, int rem) throws IOException {
        rem %= 1000000;

        if (rem < 0) {
            return 0;
        }

        if (i == k && rem == 0) {
            return 1;
        }

        if (i == k) {
            return 0;
        }

        if (grid[i][rem] != -1) {
            return grid[i][rem];
        }

        int answer = 0;

        for (int j = 0; j <= rem; ++j) {
            answer += calc(i + 1, rem - j) % 1000000;
        }

        return grid[i][rem] = answer % 1000000;

    }

}
