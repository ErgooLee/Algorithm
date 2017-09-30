import java.util.*;

/**
 * @Author: LICHAO
 * @Description:
 * @Date: Created in 1:59 PM 26/09/2017
 * @Modified By:
 */
public class MyChubao {
    public static void main() {
        f1();
    }

    public static void f1() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 1; i <= T; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Case " + i + ": " + f11(a, b));
        }
    }

    public static int f11(int a, int b) {
        int result = 0;
        while ((2 << result++) <= b) ;
        if ((2 << result - 2) - 1 >= a) {
            return (2 << result - 2) - 1;
        }



        int maxLength = 0;
        int num = 0;
        int temp;
        int countOne;
        for (int i = a; i <= b; i++) {
            countOne = 0;
            temp = i;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    countOne++;
                }
                temp >>= 1;
            }
            if (countOne > maxLength) {
                maxLength = countOne;
                num = i;
            }
        }
        return num;
    }

    public static void f2() {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] father = new int[n];
//        father[0] = -1;
//        int[] value = new int[n];
//        for (int i = 1; i < n; i++) {
//            father[i] = sc.nextInt();
//        }
//        for (int i = 0; i < n; i++) {
//            value[i] = sc.nextInt();
//        }

        int n = 6;
        int[] father = {-1, 0, 1, 0, 3,3};
        int[] value = {875, 479, 30, 217, 39, 20};

        List<Integer> childrenList = null;
        List<Integer> childrenValue = null;
        List<Integer> otherValue = null;
        LinkedList<Integer> stack;
        int result = 0;
        for (int i = 1; i < n; i++) {
            childrenList = new ArrayList<>();
            childrenValue = new ArrayList<>();
            otherValue = new ArrayList<>();
            stack = new LinkedList<>();

            otherValue.add(value[0]);
            childrenList.add(i);
            stack.addLast(i);

            while (!stack.isEmpty()) {
                int top = stack.pollLast();
                for (int j = 1; j < n; j++) {
                    if (top == father[j]) {
                        stack.addLast(j);
                        childrenList.add(j);
                    }
                }
            }
            for (int j = 1; j < n; j++) {
                if (!childrenList.contains(j)) {
                    otherValue.add(value[j]);
                }
            }
            for (int j : childrenList) {
                childrenValue.add(value[j]);
            }
            result += Math.abs(Collections.max(childrenValue) - Collections.max(otherValue));
        }
        System.out.println(result);
    }
}
