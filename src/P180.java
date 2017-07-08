/**
 * Created by lichao on 04/07/2017.
 * 两个字符串的最长子序列
 */
public class P180 implements IAlgorithm {
    private String a = "abcbdab";
    private String b = "bdcaba";
    private int[][] result;
    @Override
    public void exe() {
        result = new int[a.length() + 1][b.length() + 1];
        for (int i = 0;i<a.length() + 1;i++) {
            for (int j = 0; j < b.length() + 1; j++) {

                result[i][j] = -1;
            }

        }
        getMaxSub(a.length(), b.length());
        for (int i = 0;i<a.length() + 1;i++) {
            for (int j = 0; j < b.length() + 1; j++) {

                System.out.printf("%3d", result[i][j]);
            }
            System.out.println();
        }
    }

    public int getMaxSub(int indexA, int indexB) {
        if (indexA == 0 || indexB == 0) {
            result[indexA][indexB] = 0;
        }
        else {
            if (a.charAt(indexA - 1) == b.charAt(indexB - 1)) {
                result[indexA][indexB] = getMaxSub(indexA - 1, indexB - 1) + 1;
            } else {
                int t1 = getMaxSub(indexA, indexB - 1);
                int t2 = getMaxSub(indexA - 1, indexB);
                if (t1 > t2) {
                    result[indexA][indexB] = t1;
                } else {
                    result[indexA][indexB] = t2;
                }
            }
        }
        return result[indexA][indexB];
    }

}
