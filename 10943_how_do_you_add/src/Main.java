import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Created by annikamagnusson on 16/10/15.
 */
public class Main {
    static Scanner in;
    static String data;

    public static void main (String args[]) {
        data = "20 2\n" +
                "20 3\n" +
                "0 0";

        System.setIn(new ByteArrayInputStream(data.getBytes()));
        in = new Scanner(System.in);

        calc();
    }

    static void calc() {
        String output = "";

        while (in.hasNext()) {
            String line = in.nextLine();
            if (line.equalsIgnoreCase("0 0")) {
                System.out.println(output.substring(0, output.length() - 1));
                return;
            }

            String[] numbers = line.split(" ");

            int n = Integer.parseInt(numbers[0]);
            int k = Integer.parseInt(numbers[1]);

            int ways = (int) Math.pow((n + 1), (k - 1));

            output += ((Integer.toString(ways)) + "\n");

        }

    }

}
