
/**
 * Created by lichao on 11/07/2017.
 * 分治算法 解决比赛日程表问题
 */
public class P251 implements IAlgorithm {
    int k = 3;
    int[][] result = new int[1 << k][1 << k];
    @Override
    public void exe() {
        getK(0, 0, 3);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.printf("%3d",result[i][j]);
            }
            System.out.println();
        }

    }

    void getK(int x, int y, int k) {
        if (k == 1) {
            result[x][y] = x + 1;
            result[x + 1][y] = x + 2;
            result[x + 1][y + 1] = x + 1;
            result[x][y + 1] = x + 2;
            return;
        }
        int temp = 1 << (k - 1);
        getK(x, y, k - 1);
        for (int i = 0; i < temp; i++) {
            for (int j = 0; j < temp; j++) {
                result[x + temp + i][y + temp + j] = result[i][j];
            }
        }
        getK(x + temp, y, k - 1);
        for (int i = 0; i < temp; i++) {
            for (int j = 0; j < temp; j++) {
                result[x + i][y + temp + j] = result[x + temp + i][j];
            }
        }
    }
}
