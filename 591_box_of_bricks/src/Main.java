import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static int set;
    static String output = "";
    static BufferedReader br;

    public static void main (String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        set = 1;

        moveBricks();
    }

    static void moveBricks() throws IOException {
        //Check the number of stacks
        int numberOfStacks = Integer.parseInt(br.readLine());

        // If line is 0 then program should end
        if (numberOfStacks == 0){
            System.out.print(output.substring(0, output.length() - 1));
            return;
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

        output += "Set #" + set + "\nThe minimum number of moves is " + moves + ".\n" + "\n";
        set ++;
        moveBricks();
    }
}