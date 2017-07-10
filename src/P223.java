/**
 * Created by lichao on 09/07/2017.
 * n的全排列问题  递归解法 复杂度n的n次方
 */
public class P223 implements IAlgorithm {
    int[] result;
    boolean[] visited;
    int n;
    int total = 0;
    @Override
    public void exe() {
        n = 7;
        result = new int[n+1];
        visited = new boolean[n+1];
        getK(1);
    }

    public void getK(int k) {
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[k] = i;
                if (k == n) {
                    System.out.printf("%4d:",++total);
                    for (int j = 1; j <= n; j++) {
                        System.out.printf("%4d", result[j]);
                    }
                    System.out.println();
                }else{
                    getK(k + 1);
                }
                visited[i] = false;
            }
        }
    }

}
