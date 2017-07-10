/**
 * Created by lichao on 09/07/2017.
 * 排列树解决  八皇后问题
 */
public class P225 implements IAlgorithm {
    int[] result = new int[8];
    int total = 0;
    @Override
    public void exe() {
        for (int i = 0; i < 8; i++) {
            result[i] = i;
        }
        getK(0);
    }

    void getK(int k) {
        if (k == 8) {
            System.out.printf("%3d:", ++total);
            for (int item : result) {
                System.out.printf("%3d",item);
            }
            System.out.println();
        }
        for (int i = k; i < 8; i++) {
            swap(i, k);
            if (check(k, result[k])) {
                getK(k + 1);
            }
            swap(i, k);
        }
    }

    void swap(int i, int j) {
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }

    boolean check(int k, int value) {
        for (int i = 0; i < k; i++) {
            if (Math.abs(i - k) == Math.abs(result[i] - value)) {
                return false;
            }
        }
        return true;
    }
}
