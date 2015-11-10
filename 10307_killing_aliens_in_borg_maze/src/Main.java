import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by annikamagnusson on 10/11/15.
 *
 */
public class Main {
    private static BufferedReader in;

    public static void main (String args[]) throws IOException {
        String data = "2\n" +
                "6 5\n" +
                "##### \n" +
                "#A#A##\n" +
                "# # A#\n" +
                "#S ## \n" +
                "##### \n" +
                "7 7\n" +
                "#####  \n" +
                "#AAA###\n" +
                "# A#   \n" +
                "# S ###\n" +
                "# #    \n" +
                "#AAA###\n" +
                "#####  ";

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        in = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();
        main.start();

        in.close();
        System.exit(0);
    }

    void start() throws IOException {
        int testCases = Integer.parseInt(in.readLine());

        for(int i = 0; i < testCases; i++) {
            huntAliens();
        }


    }

    void huntAliens() throws IOException {
        int x, y;
        String[] line = in.readLine().split(" ");
        x = Integer.parseInt(line[0]);
        y = Integer.parseInt(line[1]);

        String[][] maze = new String[x][y];

        for (int i = 0; i < y; i++) {
            String[] row = in.readLine().split("");
            for(String s : row){
                System.out.println(s);
            }
            for(int j = 0; j < x; j++) {

            }
        }

    }
}
