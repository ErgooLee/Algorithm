import java.util.LinkedList;

/**
 * @Author: LICHAO
 * @Description:
 * 布线问题
 * @Date: Created in 1:49 PM 26/09/2017
 * @Modified By:
 */
public class P230 {


    static final int m = 6;
    static final int n = 6;
    static final int[] xx = {-1, 0, 1, 0};
    static final int[] yy = {0, -1, 0, 1};
    static int[][] map = {
            {-2, -2, -2, -2, -2, -2},
            {-2, -2, -1, -2, -2, -2},
            {-2, -2, -1, -2, -2, -2},
            {-2, -2, -1, -2, -2, -2},
            {-1, -1, -1, -2, -2, -2},
            {-2, -2, -2, -2, -2, -2},
    };

    static Node start = new Node(1, 1);
    static Node end = new Node(4, 4);

    public static void main() {


        map[start.x][start.y] = 0;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(start);
        Node top = null;
        int k = 0;
        while (!queue.isEmpty()) {
            top = queue.pollLast();
            k = map[top.x][top.y];
            int i = 0;
            for (i = 0; i < 4; i++) {
                int tempX = top.x + xx[i];
                int tempY = top.y + yy[i];
                if (tempX >= 0 && tempX < m && tempY >= 0 && tempY < n && map[tempX][tempY] == -2) {
                    queue.addFirst(new Node(tempX, tempY));
                    map[tempX][tempY] = k + 1;
                }
                if (tempX == end.x && tempY == end.y) {
                    out();
                    return;
                }
            }
        }
    }

    static class Node{
        public int x;
        public int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            return x == node.x && y == node.y;
        }
    }

    public static void out() {

    }
}
