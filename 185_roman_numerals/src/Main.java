import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by annikamagnusson on 12/11/15.
 *
 */
public class Main {
    private static BufferedReader in;

    public static void main(String args[]) throws IOException {
        String data = "V+V=X\n" +
                "X+X=XX\n" +
                "XX+XX=MXC\n" +
                "#";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        in = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();
        main.start();

        in.close();
        System.exit(0);
    }

    void start() throws IOException {
        while (true) {
            String line = in.readLine();

            if(line.equalsIgnoreCase("#")) {
                break;
            }
            String[] numerals = line.split("[+=]");

            if (calculateRoman(numerals[0]) + calculateRoman(numerals[1]) == calculateRoman(numerals[2])) {
                System.out.print("Correct ");
            } else {
                System.out.print("Incorrect ");
            }

        }
    }

    int decodeNumeral(char numeral) {
        switch (numeral) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;

        }


    }

    int calculateRoman(String line) {
        int result = 0;

        for (int i = 0; i < line.length(); i++) {
            if (i == line.length()-1) {
                result += decodeNumeral(line.charAt(line.length()-1));
            } else {
                int a = decodeNumeral(line.charAt(i));
                int b = decodeNumeral(line.charAt(i + 1));

                if (a < b) {
                    result -= a;
                } else {
                    result += a;
                }
            }
        }
        return result;
    }

    void calculateArabic() {
        
    }
}
