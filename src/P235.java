import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lichao on 10/07/2017.
 * 子集树解决装船问题
 */
public class P235{
    static int c1 = 50;
    static int c2 = 50;
    static int[] goods = {10, 40, 40};
    static int depth = 0;
    static int bestX = 0;

    public static void main() {
        f2();
    }
    static void f1(){//无记录
        Queue<Integer> queue;
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
            } else {
                if (top + goods[depth] <= c1) {
                    queue.add(top+goods[depth]);
                }
                queue.add(top);
            }
        }
    }
    static void f2(){//有记录
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(new Node(0, null));
        queue.addFirst(new Node(-1, null));
        Node top = null;
        int depth = 0;
        while (!queue.isEmpty()) {
            top = queue.pollLast();
            if (top.weight == -1) {
                if (depth == goods.length - 1) {//输出
                    while(!queue.isEmpty()){
                        top = queue.pollLast();
                        while (top.father != null) {
                            System.out.printf("%3d", top.weight - top.father.weight);
                            top = top.father;
                        }
                        System.out.println();
                    }
                }else{//新的一层
                    depth++;
                    queue.addFirst(new Node(-1, null));
                }
            }else{
                if (top.weight + goods[depth] <= c1) {
                    queue.addFirst(new Node(top.weight + goods[depth], top));
                }
                queue.addFirst(new Node(top.weight, top));
            }
        }
    }

    static class Node{
        int weight;
        Node father;
        public Node(int weight, Node father) {
            this.weight = weight;
            this.father = father;
        }
    }
}
