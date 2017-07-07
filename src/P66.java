/**
 * Created by lichao on 04/06/2017.
 * n个中选r个的组合问题
 */
public class P66 implements IAlgorithm {
    int[] array = new int[100];
    @Override
    public void exe() {
        int n = 5;
        int r = 3;
        array[0] = r;
        comb(n,r);
    }

    public void comb(int n, int r) {
        for (int i = n; i >= r; i--) {
            array[r] = i;
            if (r == 1) {
                for (int j = array[0]; j > 0; j--) {
                    System.out.print(array[j] + "  ");
                }
                System.out.println();
            }else
                comb(i - 1, r - 1);//这里是i-1不是n-1
        }

    }
}
