import java.util.Scanner;

class Main {
    static Scanner in;
    static float budget;

    public static void main (String args[]) {
        in = new Scanner(System.in);

        calcPremium();
    }

    static void calcPremium() {
        int firstLine = 0;
        int cases = 0;
        String strBudget = "";

        while (in.hasNext()) {
            if (firstLine == 0) {
                cases = Integer.parseInt(in.nextLine());
                firstLine++;
            }

            for (int i = 0; i < cases; i++) {
                int farmers = in.nextInt();

                for(int y = 0; y < farmers; y++) {
                    float size = in.nextFloat();
                    float animals = in.nextFloat();
                    float ecoFriendly = in.nextFloat();

                    budget += Math.round(size/animals*ecoFriendly*animals);

                }

                strBudget += ((Integer.toString((int)budget)) + "\n");
                budget = 0;
            }
        }
        System.out.println(strBudget.substring(0, strBudget.length() - 1));
    }
}
