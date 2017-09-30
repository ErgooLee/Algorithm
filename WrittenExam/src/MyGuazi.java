import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LICHAO
 * @Description:
 * @Date: Created in 4:31 PM 28/09/2017
 * @Modified By:
 */
public class MyGuazi {
    static List<List<Node>> listIn = new ArrayList<>();
    static List<List<Node>> listOut = new ArrayList<>();


    public static void main() {
        f1();
    }

    public static void f1() {
        int m = 4;
        int n = 4;
        int[][] map = {
                {1, 1, 1, 1},
                {1, 0, 0, 1},
                {1, 1, 0, 1},
                {1, 0, 1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    if (i == 0 || i == m - 1 || j == 0 || j == m - 1) {//边缘0
                        f11(new Node(i, j), true);
                    }else{//非边缘0
                        f11(new Node(i, j), false);
                    }
                }
            }
        }
        for (List<Node> no : listIn) {
            for (Node node : no) {
                map[node.x][node.y] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d", map[i][j]);
            }
            System.out.println();
        }

    }


    public static void f11(Node node,boolean edge) {
        if (edge) {
            if (listOut.isEmpty()) {
                ArrayList<Node> l = new ArrayList<>();
                l.add(node);
                listOut.add(l);
            }else{//将listIn到listOut
                List<Node> in = combine(listIn, node);
                List<Node> out = combine(listOut, node);
                if (in != null && out != null) {
                    listIn.remove(in);
                    out.addAll(in);
                }
            }
        }else{
            if (listIn.isEmpty()) {
                ArrayList<Node> l = new ArrayList<>();
                l.add(node);
                listIn.add(l);
            }else{//加入到ListIn
                combine(listIn, node);
            }
        }
    }

    static List<Node> combine(List<List<Node>> list, Node node) {
        List<List<Node>> nearList = new ArrayList<>();
        for (int k = 0; k < list.size(); k++) {
            List<Node> l = list.get(k);
            for (int j = 0; j < l.size(); j++) {
                Node n = l.get(j);
                if (node.isNear(n)) {
                    nearList.add(l);
                }
            }
        }
        if (nearList.size() == 0) {
            ArrayList<Node> temp = new ArrayList<>();
            temp.add(node);
            list.add(temp);
            return null;
        }else{
            List<Node> first = nearList.get(0);
            first.add(node);
            for (int z = 1; z < nearList.size(); z++) {
                List<Node> temp = nearList.get(z);
                first.addAll(temp);
                list.remove(temp);
            }
        }
        return nearList.get(0);
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
}
