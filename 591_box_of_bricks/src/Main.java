import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader br;

    public static void main (String args[]) throws IOException {
        String data = "6\n" +
                "5 5 5 5 5 7\n" +
                "4\n" +
                "2 2 2 1\n" +
                "10\n" +
                "100 100 100 100 100 100 100 100 100 -100\n" +
                "5\n" +
                "-45 -23 -2 5 -100\n" +
                "6\n" +
                "100 -100 100 -100 100 -100\n" +
                "0";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        br = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();
        main.moveBricks();

        br.close();
        System.exit(0);
    }

    void moveBricks() throws IOException {
        int set = 1;
        //Check the number of stacks
        int numberOfStacks = Integer.parseInt(br.readLine());

        while (numberOfStacks != 0) {
            if (set != 1) {
                System.out.println("");
            }
            // Read the line with stacks
            String bricksInStacks = br.readLine();

            // Split the line into stacks
            String[] stacks = bricksInStacks.split(" ");

            int moves = 0;

            int totalNumberOfBricks = 0;

            for (int e = 0; e < numberOfStacks; e++) {
                int bricksInStack = Integer.parseInt(stacks[e]);
                totalNumberOfBricks += bricksInStack;

            }

            int wallHeight = totalNumberOfBricks/numberOfStacks;

            for(int i = 0; i < numberOfStacks; i++) {
                int bricksInStack = Integer.parseInt(stacks[i]);

                if (bricksInStack > wallHeight) {
                    moves += bricksInStack-wallHeight;
                }
            }

            System.out.println("Set #" + set);
            System.out.println("The minimum number of moves is " + moves);
            set ++;
            numberOfStacks = Integer.parseInt(br.readLine());
        }
    }
}