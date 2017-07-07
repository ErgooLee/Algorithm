/**
 * Created by lichao on 06/06/2017.
 * 1 12 11 10
 * 2 13 16 9
 * 3 14 15 8
 * 4 5  6  7
 */
public class P83 implements IAlgorithm {

    @Override
    public void exe() {
        int array[][] =new int[100][100];
        int n = 5;
        int k = 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n - 2 * i - 1; j++) {

                array[i+j][i] = k;
                k++;
            }
            for (int j = 0; j < n - 2 * i - 1; j++) {

                array[n - i - 1][i + j] = k;
                k++;
            }
            for (int j = 0; j < n - 2 * i - 1; j++) {

                array[n - i - j - 1][n - i - 1] = k;
                k++;
            }
            for (int j = 0; j < n - 2 * i - 1; j++) {
                array[i][n - i - j - 1] = k;
                k++;
            }
        }
        if (n % 2 == 1) {
            array[n / 2][n / 2] = n * n;
        }
        for (int i = 0; i < n; i++) {
            System.out.println();
            for (int j = 0; j < n; j++) {
                String out = String.format("%4d",array[i][j]);
                System.out.print(out + " ");

            }
        }

    }
}
