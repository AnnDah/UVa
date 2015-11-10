import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Main {
    static Scanner in;
    static class Node {
        boolean grouped = false;

        List<Node> friends;

        Node() {
            friends = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++) {
            calcFriends();
        }

    }

    static void calcFriends() {
        int citizens = in.nextInt();
        int pairs = in.nextInt();
        int group = -1;

        Node[] graph = new Node[citizens+1];

        for (int c = 1; c <= citizens; c++ ) {
            graph[c] = new Node();
        }

        for (int p = 0; p < pairs; p++) {
            int person1 = in.nextInt();
            int person2 = in.nextInt();

            graph[person1].friends.add(graph[person2]);
            graph[person2].friends.add(graph[person1]);
        }

         for (int i = 1; i <= citizens; i++) {
             if (!graph[i].grouped) {
                 group = Math.max(group, createGroup(graph[i]));
             }
         }

        System.out.println(group);

    }

    static int createGroup (Node node) {
        int size = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (!n.grouped) {
                size++;
                n.grouped = true;

                for (Node x : n.friends) {
                    queue.add(x);
                }
            }
        }

        return size;
    }
}
