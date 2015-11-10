import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by annikamagnusson on 10/11/15.
 *
 */
public class Main {
    private static BufferedReader in;
    String output = "";

    public static void main(String args[]) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();
        main.start();

        in.close();
        System.exit(0);
    }

    void start() throws IOException {
        int citizens = Integer.parseInt(in.readLine());
        long work = 0;
        long buffer = 0;

        if (citizens == 0) {
            System.out.println(output.substring(0, output.length() - 1));
            return;
        }

        String[] trades = in.readLine().split(" ");

        for(int i = 0; i < citizens; i++) {
            int bottles = Integer.parseInt(trades[i]);

            buffer = buffer - bottles;
            work = work + Math.abs(buffer);
        }

        output += work + "\n";

        start();

    }
}
