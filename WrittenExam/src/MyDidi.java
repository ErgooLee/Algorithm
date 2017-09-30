import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: LICHAO
 * @Description:
 * @Date: Created in 7:41 PM 23/09/2017
 * @Modified By:
 */
public class MyDidi {
    static List<List<Node>> list =new ArrayList<>();
    static int k;
    public static void main() {
        f2();
    }

    public static void f2() {
        Scanner sc = new Scanner(System.in);
        double R = sc.nextDouble();
        BigDecimal result = new BigDecimal(R);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            result.multiply(new BigDecimal(R));
        }
        String s = result.toString();

    }

    public static void f1() {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x >= 0 && x < m && y >= 0 && y < n) {
                f11(new Node(x, y), i);
            } else {
                out(i);
            }
        }

    }

    public static void f11(Node node,int i) {
        if (list.isEmpty()) {
            ArrayList<Node> l = new ArrayList<>();
            l.add(node);
            list.add(l);
        }else{
            List<List<Node>> nearList = new ArrayList<>();
            for (int k = 0; k < list.size(); k++) {
                List<Node> l = list.get(k);
                for (int j = 0; j < l.size(); j++) {
                    Node n = l.get(j);
                    if (node.x == n.x && node.y == n.y) {
                        out(i);
                        return;
                    } else {
                        if (node.isNear(n)) {
                            nearList.add(l);
                        }
                    }
                }
            }
            if (nearList.size() == 0) {
                ArrayList<Node> temp = new ArrayList<>();
                temp.add(node);
                list.add(temp);
            }else{
                List<Node> first = nearList.get(0);
                first.add(node);
                for (int z = 1; z < nearList.size(); z++) {
                    List<Node> temp = nearList.get(z);
                    first.addAll(temp);
                    list.remove(temp);
                }
            }
        }
        out(i);

    }
    static class Node{
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isNear(Node node) {
            return (Math.abs(x - node.x) + Math.abs(y - node.y)) == 1;
        }
    }
    public static void out(int i){
        if (i == k - 1) {
            System.out.printf(list.size()+"");
        }else{
            System.out.printf(list.size()+" ");
        }
    }
}
