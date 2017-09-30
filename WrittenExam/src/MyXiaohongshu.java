
import com.sun.deploy.util.StringUtils;

import java.math.BigInteger;
import java.util.*;

/**
 * @Author: LICHAO
 * @Description:
 * @Date: Created in 6:45 PM 28/09/2017
 * @Modified By:
 */
public class MyXiaohongshu {
    public static void main() {
        f1();
        System.out.println("001200".replaceAll("^0+",""));
        System.out.println(Arrays.toString("A3E4".split("[A-Z]+")));
    }

    public static void f1() {
//        Scanner sc = new Scanner(System.in);
//        String string = sc.next();
        String string = "A3E4";
        if(string.length()==0){
            System.out.println(-1);
            return;
        }
        string = string.replace("RED", "");
        String[] array = string.split("[A-Z]+");
        ArrayList<String> list = new ArrayList<>();
        if (array.length == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals("")){
                list.add(array[i]);
            }
        }
        Collections.sort(list,new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                BigInteger a = new BigInteger(o1);
                BigInteger b = new BigInteger(o2);
                return a.compareTo(b);
            }
        });

        System.out.println(list.get(list.size() - 1));
    }


    public static void f2(){
        Scanner sc = new Scanner(System.in);
//        String string = sc.next();
//        int k = sc.nextInt();
        String string = "abcdef";
        int k = 4;
        StringBuilder sb = new StringBuilder();
        int mod = string.length() % (2 * k);
        for (int i = 0; i < string.length() - mod; i = i + 2 * k) {
            for (int j = i + k - 1; j >= i; j--) {
                sb.append(string.charAt(j));
            }
            for (int j = i + k; j < i + 2 * k; j++) {
                sb.append(string.charAt(j));
            }
        }
        if (mod >= k) {
            int j = string.length() - mod;
            for (int i = j + k -1; i >= j; i--) {
                sb.append(string.charAt(i));
            }
            for (int i = j + k; i < string.length(); i++) {
                sb.append(string.charAt(i));
            }

        }else{
            for (int i = string.length() - 1;i>=string.length() - mod;i--) {
                sb.append(string.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }

    public static void f3() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();
        Node[] array = new Node[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            array[i] = new Node(a, b);
        }

        Arrays.sort(array, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.a - o2.a;
            }
        });
        for (int i = n - 1; i >= 0; i--) {
            int a = p / array[i].a;
            if (a >= array[i].b) {
                p = p - array[i].a * array[i].b;
            }else{
                p = p - array[i].a * a;
            }
        }
        System.out.println(p);


    }
    static class Node{
        int a;
        int b;
        public Node(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}