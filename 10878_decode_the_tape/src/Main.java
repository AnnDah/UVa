import java.util.Scanner;

class Main {
    static Scanner in;

    public static void main (String args[]) {
        in = new Scanner(System.in);
        decodeTape();

    }

    static void decodeTape() {
        in.nextLine();
        String sentence = "";
        while (in.hasNext()) {
            String line = in.nextLine();
            String binary = "";

            if (line.contains("___________")) {
                System.out.print(sentence);
                return;

            }
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == 'o') {
                    binary += "1";
                } else if (line.charAt(i) == ' ') {
                    binary += "0";

                }
            }
            int binaryChar = Integer.parseInt(binary, 2);

            sentence += Character.toString((char) binaryChar);

        }

    }
}