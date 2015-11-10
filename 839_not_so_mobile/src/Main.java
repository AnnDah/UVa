import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by annikamagnusson on 17/09/15.
 *
 */
class Main {
    static BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
    static boolean inBalance;

    public static void main (String[] args) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++ ) {
            reader.readLine();

            inBalance = true;

            checkEquilibrium();

            if(inBalance) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            if(i != testCases - 1) {
                System.out.println();
            }

        }
    }

    static int checkEquilibrium() throws IOException {
        int wl, dl, wr, dr;

        String[] t = reader.readLine().split(" ");

        wl = Integer.parseInt(t[0]);
        dl = Integer.parseInt(t[1]);
        wr = Integer.parseInt(t[2]);
        dr = Integer.parseInt(t[3]);

        // Test left side
        if(wl == 0) {
            wl = checkEquilibrium();
        }

        // Test right side
        if(wr == 0) {
            wr = checkEquilibrium();
        }

        // Check if the mobile is in equilibrium
        if(wl*dl == wr*dr) {
            return wl + wr;
        } else {
            inBalance = false;
            return 0;
        }
    }

}
