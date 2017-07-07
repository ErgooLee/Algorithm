/**
 * Created by lichao on 04/06/2017.
 * 整数划分问题
 * 6
 * 1+5
 * 2+4 1+1+4
 * 3+3 2+1+3 1+1+1+3
 * 2+2+2 2+2+1+1 2+1+1+1+1
 * 1+1+1+1+1+1
 */
public class P60 implements IAlgorithm{
    @Override
    public void exe() {
        System.out.println(Q(6, 6));
    }

    public int Q(int m, int n) {
        if (m == 1 || n == 1) {//这个要放到前面，挪到后面会有问题，递归出路要靠前。
            return 1;
        }
        if (m == n) {
            return Q(m,n-1) + 1;
        }
        if (m < n) {
            return Q(m, m);
        }

        else{
            return Q(m - n, n) + Q(m, n - 1);
        }
    }
}
