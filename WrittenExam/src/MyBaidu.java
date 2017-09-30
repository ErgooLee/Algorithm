import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author: LICHAO
 * @Description:
 * @Date: Created in 7:53 PM 27/09/2017
 * @Modified By:
 */
public class MyBaidu {
    public static void main() {
        f3();
    }

    public static void f2() {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int result = 0;
        int next = 2;
        int count = 0;
        while(true){
            if (isS(next)) {
                int reverse = Integer.parseInt(new StringBuilder(String.valueOf(next)).reverse().toString());
                if (isS(reverse)){
                    result = next;
                    count++;
                    if (count == K){
                        System.out.println( result <= 1000000 ? result : -1);
                        return;
                    }
                }
            }
            next++;
        }
    }

    public static boolean isS(int n) {
        if (n == 1) {
            return false;
        }else{
            boolean result = true;
            int k = 2;
            int top = (int)Math.sqrt(n);
            while (k <= top) {
                if (n % k == 0) {
                    result = false;
                    break;
                }
                k++;
            }
            return result;
        }
    }

    public static void f3(){

        int K = 3;
        int[][] data = {
                {0,0,0,0,1,2,0,0},
                {0,0,0,0,0,0,10,6},
                {0,0,0,0,0,0,25,1}
        };
        int n = 9;

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < K; i++) {
            for (int countN = 1; countN <= n; countN++) {//计算n次fn

                int nn = 1;
                int sum = 0;
                for (int j = 7; j >= 0; j--) {
                    sum += nn * data[i][j];
                    nn = nn * countN;
                }
                set.add(sum);
            }
        }
        for (Integer i : set) {
            System.out.println(i);
        }

    }
}
