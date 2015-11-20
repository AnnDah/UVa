import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        int numOfCoords = Integer.parseInt(in.readLine());

        while (numOfCoords != 0) {
            List<Point> points = new ArrayList<>();

            for (int i = 0; i < numOfCoords; i++) {
                String[] coords = in.readLine().split(" ");
                Point point = new Point();
                point.x = Integer.parseInt(coords[0]);
                point.y = Integer.parseInt(coords[1]);

                points.add(point);
            }

            int sum;

            boolean way = false;

            //check which way the polygon turns
            if (calc(points.get(0), points.get(1), points.get(2)) >= 0){
                way = true;
            }
            int j;

            for (j = 0; j < numOfCoords; j++) {
                if (j == numOfCoords-1) {
                    sum = calc(points.get(j), points.get(0), points.get(1));
                } else if (j == numOfCoords-2) {
                    sum = calc(points.get(j), points.get(j+1), points.get(0));
                } else {
                    sum = calc(points.get(j), points.get(j+1), points.get(j+2));
                }

                if (way && sum < 0) {
                    break;
                }

                if (!way && sum > 0) {
                    break;
                }
            }

            if (j != numOfCoords) {
                System.out.println("Yes");

            } else {
                System.out.println("No");
            }

            numOfCoords = Integer.parseInt(in.readLine());
        }
    }

    int calc(Point p, Point q, Point r) {
        int sum = (r.x-q.x) * (p.y-q.y) - (r.y-q.y) * (p.x-q.x);
        if (0 < sum) {
            return 1;
        }
        if (sum < 0) {
            return -1;
        }

        return 0;
    }

    class Point {
        int x, y;
    }
}
