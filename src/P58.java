/**
 * Created by lichao on 03/06/2017.
 * 汉诺塔问题
 */
public class P58 implements IAlgorithm {
    @Override
    public void exe() {
        hanoi(6,'a','b','c');
    }

    public void hanoi(int n, char a, char b, char c) {
        if (n > 0) {
            hanoi(n - 1, a, c, b);
            System.out.println(n + "-->" + c);
            hanoi(n - 1, b, a, c);
        }
    }
}
