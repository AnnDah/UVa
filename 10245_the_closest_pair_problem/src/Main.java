import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by annikamagnusson on 20/11/15.
 *
 */
class Main {
    private static BufferedReader in;

    public static void main(String args[]) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();
        main.start();

        in.close();
        System.exit(0);


    }

    void start() throws IOException {
        int numberOfPoints = Integer.parseInt(in.readLine());

        while(true) {
            List<Point> points = new ArrayList<>();
            double closest = 10000;

            for (int i = 0; i < numberOfPoints; i++) {
                String[] coords = in.readLine().split(" ");

                Point point = new Point();
                point.x = Integer.parseInt(coords[0]);
                point.y = Integer.parseInt(coords[1]);

                points.add(point);
            }

            for (int i = 0; i < numberOfPoints; i++) {
                for (int j = i+1; j < numberOfPoints; j++) {
                    double dist = distance(points.get(i), points.get(j));

                    if (dist < closest) {
                        closest = dist;
                    }
                }
            }

            if (closest == 10000) {
                System.out.println("INFINITY");
            } else {
                System.out.println(String.format("%.4f", closest));
            }

            numberOfPoints = Integer.parseInt(in.readLine());

            if (numberOfPoints == 0) {
                return;
            }

        }

    }

    double distance(Point p, Point q) {
        return Math.sqrt(Math.pow(Math.abs(q.x - p.x), 2) + Math.pow(Math.abs(q.y - p.y), 2));
    }

    class Point {
        int x, y;
    }
}
