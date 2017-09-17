/**
 *2017年09月15日22:19:07
 * 求最长不下降子序列
 *
 */
public class P184 {
    public static void main(String[] args) {
        int[] data = {3, 18, 7, 14, 10, 12, 23, 41, 16, 24};
        int[] a = new int[data.length];
        int[] b = new int[data.length];
        a[0] = -1;
        b[0] = 1;
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                int maxLen = 0;
                int index = 0;
                if (data[j] >= data[i]) {
                    if (b[i] > maxLen){
                        index = j;
                    }
                }
            }

        }
    }
}
