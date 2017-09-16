import java.util.stream.IntStream;
/**
 * 求两个字符串的最长子序列
 *
 */
public class LCS {
    static String a = "abcbdab";
    static String b = "bdcaba";
    static int[][] result;
    public static void main() {
//        result = new int[a.length() + 1][b.length() + 1];
//        getLCS(a.length() - 1, b.length() - 1);
//        for (int i = 0; i < a.length() + 1; i++) {
//            for (int j = 0; j < b.length() + 1; j++) {
//                System.out.printf("%4d",result[i][j]);
//            }
//            System.out.println();
//        }

        getLCS_2();
    }

    static void getLCS(int x, int y) {
        if (x < 0 || y < 0) {
            return;
        }
        if (a.charAt(x) == b.charAt(y)) {

            getLCS(x - 1, y - 1);
            result[x + 1][y + 1] = result[x][y] + 1;
        } else {
            getLCS(x - 1, y);
            getLCS(x, y - 1);
            if (result[x][y + 1] > result[x + 1][y]) {
                result[x + 1][y + 1] = result[x][y + 1];
            } else {
                result[x + 1][y + 1] = result[x + 1][y];
            }
        }
    }

    static void getLCS_2() {
        result = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else if (result[i - 1][j] > result[i][j - 1]) {
                    result[i][j] = result[i - 1][j];
                }else{
                    result[i][j] = result[i][j - 1];
                }
            }
        }
        for (int i = 0; i < a.length() + 1; i++) {
            for (int j = 0; j < b.length() + 1; j++) {
                System.out.printf("%4d",result[i][j]);
            }
            System.out.println();
        }
    }
}
