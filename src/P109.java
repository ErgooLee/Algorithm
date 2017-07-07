import java.util.Arrays;

/**
 * Created by lichao on 06/06/2017.
 * 数组平移操作
 */
public class P109 implements IAlgorithm {
    @Override
    public void exe() {
        int[] array = new int[100];
        for (int i = 0;i<100;i++) {
            array[i] = i;
        }
        int m = 30;
        int n = 2;
        int max = 1;
        for (int a = m, b = n, r = n; b > 1 && r > 0; ) {
            r = a % b;
            a = b;
            max = b;
            b = r;
        }
        System.out.println(max);
        for (int i = 0; i < max; i++) {
            int temp = array[m - i - 1];
            int t1,t2 = 0;
            for (int j = 0; j < m / max - 1; j++) {
                t1 = (2 * m - i - 1 - j * n) % m;
                t2 = (t1 - n + m) % m;
                array[t1] = array[t2];
            }
            array[t2] = temp;

        }
        for (int i = 0; i < m; i++) {

            System.out.print(array[i] + "  ");
        }
    }
}
