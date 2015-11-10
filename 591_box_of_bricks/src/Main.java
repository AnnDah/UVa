import java.util.Scanner;

class Main {
    static Scanner scanner;
    static int set;
    static String output = "";

    public static void main (String args[]) {
        scanner = new Scanner(System.in);
        set = 1;
        moveBricks();
    }

    static void moveBricks() {
        int numberOfStacks = Integer.parseInt(scanner.nextLine());

        if (numberOfStacks == 0){
            System.out.print(output.substring(0, output.length() - 1));
            return;
        }

        String bricksInStacks = scanner.nextLine();

        int moves = 0;

        int totalNumberOfBricks = 0;
        int charEPosition = 0;

        for (int e = 0; e < numberOfStacks; e++) {
            int bricksInStack = Character.getNumericValue(bricksInStacks.charAt(charEPosition));
            totalNumberOfBricks += bricksInStack;
            charEPosition += 2;

        }

        int wallHeight = totalNumberOfBricks/numberOfStacks;

        int charIPosition = 0;

        for(int i = 0; i < numberOfStacks; i++) {
            int bricksInStack = Character.getNumericValue(bricksInStacks.charAt(charIPosition));

            if (bricksInStack > wallHeight) {
                moves += bricksInStack-wallHeight;
            }

            charIPosition += 2;
        }

        output += "Set #" + set + "\nThe minimum number of moves is " + moves + ".\n";
        set ++;
        moveBricks();
    }
}
