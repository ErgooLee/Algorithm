import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lichao on 10/07/2017.
 * 子集树解决装船问题
 */
public class P235 implements IAlgorithm {
    int c1 = 50;
    int c2 = 50;
    int[] goods = {10, 40, 40};
    Queue<Integer> queue;
    int depth = 0;
    int bestX = 0;
    @Override
    public void exe() {
        queue = new LinkedList<>();
        int top;

        queue.offer(0);
        queue.offer(-1);
        while (!queue.isEmpty()) {
            top = queue.poll();
            if (top == -1) {
                if (depth == goods.length - 1) {
                   while(!queue.isEmpty()){
                       top = queue.poll();
                       if (top > bestX) {
                           bestX = top;
                       }
                   }
                   System.out.println(bestX);
                }else{
                    queue.add(-1);
                    depth++;
                }
            }
            else {
                if (top + goods[depth] <= c1) {
                    queue.add(top+goods[depth]);
                }
                queue.add(top);
            }
        }
    }
}
