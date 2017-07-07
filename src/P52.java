import java.util.Scanner;

/**
 * Created by lichao on 02/06/2017.
 * 1/1! - 1/3！ + 1/5! -1/7!+……+(-1)(n+1)/(2n-1)!
 */
public class P52 implements IAlgorithm{
    @Override
    public void exe() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = 1;
        double denominator = 1;
        for (float i = 2; i <= n; i++) {
            denominator = -1 * denominator * (2 * i - 1) * (2 * i - 2);
            sum += 1 / denominator;
            System.out.println(denominator);
        }
        System.out.println(sum);
    }
}
