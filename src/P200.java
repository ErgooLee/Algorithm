import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lichao on 06/07/2017.
 * 深度优先和广度优先解决迷宫问题。
 */
public class P200 implements IAlgorithm {
    int[][] data = new int[][]{
            {0,0,0,0,0,0,0,0},
            {0,1,1,1,1,0,1,0},
            {0,0,0,0,1,0,1,0},
            {0,1,0,0,0,0,1,0},
            {0,1,0,1,1,0,1,0},
            {0,1,0,0,0,0,1,1},
            {0,1,0,0,1,0,0,0},
            {0,1,1,1,1,1,1,0}
    };
    int[][] visited = new int[8][8];
    int[][] result = new int[8][8];
    int[] xx = {1, 0, -1, 0};
    int[] yy = {0, 1, 0, -1};
    @Override
    public void exe() {
//        bfs();
        dfs(0   ,0);

    }
    public class Node{
        public int x;
        public int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean check(int x, int y) {
        if (x >= 0 && x <= 7 && y >= 0 && y <= 7 && visited[x][y] != 1 && data[x][y] != 1) {

            return true;
        }
        return false;
    }
    public void bfs(){

        for (int i = 0;i<8;i++) {
            for (int j = 0;j<8;j++) {
                result[i][j] = -1;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));
        visited[0][0] = 1;
        Node top;
        while (!queue.isEmpty()) {
            top = queue.poll();
            for (int i = 0; i < 4; i++) {
                Node next = new Node(top.x + xx[i], top.y + yy[i]);
                if (check(next.x, next.y)) {
                    result[next.x][next.y] = i;
                    visited[next.x][next.y] = 1;
                    queue.offer(next);
                }
                if (next.x == 7 && next.y == 7) {
                    System.out.println("done");
                    out();
                    return;
                }
            }
        }
    }

    public void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + xx[i];
            int nextY = y + yy[i];
            if (check(nextX,nextY)){
                visited[x][y] = 1;
                result[nextX][nextY] = i;
                if (nextX == 7 && nextY == 7) {
                    out();
                    return;
                }else{
                    dfs(nextX,nextY);
                }
            }
        }

    }
    public void out(){
        int preX = 7;
        int preY = 7;
        while(true){
            System.out.println("(" + preX + "," + preY + ")");
            if (preX == 0 && preY == 0) {
                return;
            }
            int pre = result[preX][preY];
            preX = preX - xx[pre];
            preY = preY - yy[pre];
        }
    }
}
