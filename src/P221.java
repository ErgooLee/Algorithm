/**
 * Created by lichao on 08/07/2017.
 * 回溯  非递归解n r的组合问题
 */
public class P221 implements IAlgorithm {
    @Override
    public void exe() {
        int n = 9;
        int r = 5;
        int k = 0;
        int[] result = new int[r];
        result[0] = n+1;
        while (k >= 0) {
            result[k] = result[k] - 1;
            if (result[k] >= r - k) {
                if (k == r - 1) {
                    for (int i : result) {
                        System.out.printf("%3d", i);
                    }
                    System.out.println();
                }else{
                    k = k + 1;
                    result[k] = result[k - 1];
                }
            }else{
                k--;
            }
        }
    }
}

