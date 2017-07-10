/**
 * Created by lichao on 09/07/2017.
 */
public class P224 implements IAlgorithm {
    int n;
    int[] result;
    int total;
    @Override
    public void exe() {
        n = 4;
        result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = i;
        }
        getK(1);

    }

    public void getK(int k) {
        if (k == n) {
            System.out.printf("%4d:",++total);
            for (int j = 1; j <= n; j++) {
                System.out.printf("%4d", result[j]);
            }
            System.out.println();
        }else{
            for (int i = k; i <= n; i++) {
                swap(k, i);
                getK(k + 1);
                swap(k, i);
            }
        }
    }

    public void swap(int i, int j) {

        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }
}
