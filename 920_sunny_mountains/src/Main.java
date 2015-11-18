import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by annikamagnusson on 18/11/15.
 *
 */
public class Main {
    private static BufferedReader in;

    public static void main(String args[]) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();
        main.start();

        in.close();
        System.exit(0);
    }

    void start() throws IOException {
        int testCases = Integer.parseInt(in.readLine());

        for (int i = 0; i < testCases; i++) {
            double sunnySide = 0;

            int rows = Integer.parseInt(in.readLine());

            List<Point> points = new ArrayList<>();

            for (int j = 0; j < rows; j++) {
                String[] cords = in.readLine().split(" ");
                Point point = new Point();
                point.x = Double.parseDouble(cords[0]);
                point.y = Double.parseDouble(cords[1]);
                points.add(point);


            }

            Collections.sort(points);

            double highestPoint = 0;

            for(int k = 0; k < rows; k++) {
                if (k > 0) {
                    if (points.get(k).y > highestPoint) {
                        double a = (points.get(k).y) - (points.get(k - 1).y);
                        double b = (points.get(k - 1).x) - (points.get(k).x);
                        double c = (points.get(k).y) - highestPoint;

                        highestPoint = points.get(k).y;

                        sunnySide += calcSunnySide(a, b, c);

                    }
                }

            }



            String result = String.format("%.2f", sunnySide);
            System.out.println(result);
        }

    }

    double calcSunnySide(double a, double b, double c) {
        return (c / (Math.cos(((Math.toDegrees(Math.atan(b / a))) * Math.PI / 180.0))));

    }

    class Point implements Comparable<Point> {
        double x;
        double y;

        @Override
        public int compareTo(Point o) {
            int compare = (int) o.x;
            return (int) (compare - x);
        }
    }
}
