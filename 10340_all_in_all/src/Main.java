import java.io.IOException;
import java.util.Scanner;

/**
 * Created by annikamagnusson on 10/11/15.
 *
 */
public class Main {
    private static Scanner in;

    public static void main(String args[]) throws IOException {
        in = new Scanner(System.in);

        Main main = new Main();
        main.start();

        in.close();
        System.exit(0);
    }

    void start() throws IOException {
        while(in.hasNext()) {
            String line = in.nextLine();
            compare(line);

        }
    }

    void compare(String line) {
        if (line.equals("") || line == null) {
            return;
        }

        String[] strings = line.split(" ");

        String string1 = strings[0];
        String string2 = strings[1];

        char[] c1 = new char[string1.length()];
        char[] c2 = new char[string2.length()];

        for (int i = 0; i < string1.length(); i++) {
            c1[i] = string1.charAt(i);
        }

        for (int i = 0; i < string2.length(); i++) {
            c2[i] = string2.charAt(i);
        }

        int i = 0;
        int check = 0;

            for (int j = 0; j < c2.length; j++) {
                char char1 = c1[i];
                char char2 = c2[j];
                if (char1 == char2) {
                    check++;
                    i++;
                }
                if (check >= c1.length) {
                    System.out.println("Yes");
                    return;
                }
            }

        System.out.println("No");
    }
}
