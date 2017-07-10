import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lichao on 10/07/2017.
 * 构造二叉子集树
 */
public class P237 implements IAlgorithm {
    int c1 = 50;
    int c2 = 50;
    int[] goods = {10, 40, 40};
    Queue<Node> queue;
    int depth = 0;
    Node bestNode = new Node(0, null, false);
    @Override
    public void exe() {
        queue = new LinkedList<>();
        queue.add(new Node(0, null, false));
        queue.add(new Node(-1, null, false));
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            if (top.weight == -1) {
                if (depth == goods.length - 1) {
                    out();
                }else{
                    queue.add(top);
                    depth++;
                }
            }
            else {
                if (top.weight + goods[depth] <= c1) {
                    queue.add(new Node(top.weight + goods[depth], top, true));
                }
                queue.add(new Node(top.weight, top, false));
            }
        }
    }
    class Node{
        int weight;
        Node parent;
        boolean isSelected;
        public Node(int weight, Node parent, boolean isSelected) {
            this.weight = weight;
            this.parent = parent;
            this.isSelected = isSelected;
        }
    }
    public void out(){
        while (!queue.isEmpty()) {
            Node top = queue.poll();
            if (bestNode.weight < top.weight) {
                bestNode = top;
            }
        }
        System.out.println(bestNode.weight);
        while (bestNode != null) {
            System.out.println(bestNode.isSelected);
            bestNode = bestNode.parent;
        }
    }
}
