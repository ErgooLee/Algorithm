import java.util.Scanner;

/**
 * Created by lichao on 03/06/2017.
 * 1
 * 5 2
 * 8 6 3
 * 10 9 7 4
 */
public class P56 implements IAlgorithm {
    @Override
    public void exe() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[100][100];
        int index = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                array[j+i][j] = index;
                index ++;
            }
        }
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j <= i; j++) {
                System.out.print(array[i][j] + " ");
            }
        }
    }
}
