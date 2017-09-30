import java.util.stream.IntStream;

/**
 * @Author: LICHAO
 * @Description:
 * @Date: Created in 5:08 PM 23/09/2017
 * @Modified By:
 */
public class Temp {
    static final int NUM = 7;
    static int[] out = new int[NUM];
    static int count = 0;
    public static void main() {
        for (int i = 0; i < NUM; i++) {
            out[i] = i + 1;
        }
        combination(0);
    }

    public static void combination(int k) {
        if (k == NUM) {
            print();
            return;
        }
        for (int i = k; i < NUM; i++) {
            swap(i, k);
            combination(k + 1);
            swap(i, k);
        }
    }

    public static void swap(int i, int j) {
        int temp = out[i];
        out[i] = out[j];
        out[j] = temp;
    }

    public static void print() {
        System.out.printf("%-4d:", ++count);
        for (int i = 0; i < NUM; i++) {
            System.out.printf("%2d", out[i]);
        }
        System.out.println();
    }

}
