import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lichao on 06/07/2017.
 *最短路径问题(所有路径默认距离为1)  广度优先搜索
 *
 * 注意result的巧妙用法
 */
public class P198 implements IAlgorithm {
    @Override
    public void exe() {
        final int NODE = 8;
        int result[] = new int[NODE];
        int visited[] = new int[NODE];
        Queue<Integer> queue = new LinkedList<>();
        int[][] data = new int[][]{
                {0,1,1,1,0,1,0,0},
                {1,0,0,0,0,1,0,0},
                {1,0,0,1,1,0,0,0},
                {1,0,1,0,0,0,1,0},
                {0,0,1,0,0,0,1,1},
                {1,1,0,0,0,0,0,1},
                {0,0,0,1,1,0,0,1},
                {0,0,0,0,1,1,1,0}
        };
        queue.offer(0);
        visited[0] = 1;
        int top;
        while (!queue.isEmpty()) {
            top = queue.poll();
            for (int i = 0; i < NODE; i++) {
                if (data[top][i] == 1 && visited[i] != 1) {
                    queue.offer(i);
                    result[i] = top;
                    visited[i] = 1;
                    if (i == NODE - 1) {
                        int j = 7;
                        while (j > 0) {
                            System.out.printf("%c", j + 'A');
                            j = result[j];
                        }
                        System.out.println('A');
                    }
                }
            }

        }


    }
}
