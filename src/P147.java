
/**
 * Created by lichao on 02/07/2017.
 *大整数乘法
 */
public class P147 implements IAlgorithm{
    @Override
    public void exe() {
        char[] result = new char[100];
        for (int i = 0;i<100;i++) {
            result[i] = 0;
        }

        char[] a = "999999999999999".toCharArray();
        char[] b = "888888888888888".toCharArray();
        char c = 0;
        char d = 0;
        char e = 0;
        int index = 99;
        char tmp;
        for (int i = b.length - 1; i >= 0; i--) {
            index = 99 - b.length + i + 1;
            d = 0;
            for (int j = a.length - 1; j >= 0; j--) {
                c = (char) ((b[i] - '0') * (a[j] - '0') + d);
                d = (char) (c / 10);
                e = (char) (c % 10);
                tmp = (char) (result[index] + e);
                result[index] = (char) (tmp % 10);
                d = (char) (d + tmp / 10);
                index --;
            }
            if (d != 0) {
                result[index] = (char) (result[index] + d);
            }
        }
        for (int i = index; i < 100; i++) {
            if (i == index && result[i] == 0) {
                continue;
            }
            System.out.print((char) (result[i] + '0'));
        }

    }
}
