/**
 * Created by lichao on 04/07/2017.
 */
public class P166 implements IAlgorithm {
    @Override
    public void exe() {
        int[][] data = {{9}, {12, 15}, {10, 6, 8}, {2, 18, 9, 5}, {19, 7, 10, 4, 16}};
        int[][] result = new int[4][5];
        int[] add = {19, 7, 10, 4, 16};
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {

                if (add[j] > add[j + 1]) {
                    add[j] = add[j] + data[i][j];
                    result[i][j] = 1;
                } else {
                    add[j] = add[j + 1] + data[i][j];
                    result[i][j] = 0;
                }
            }
        }
        for (int i = 0;i<4;i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
        System.out.println(add[0]);
        System.out.print(data[0][0] + "  ");
        int j = 1- result[0][0];
        for (int i = 0; i < 4; i++) {

            System.out.print(data[i + 1][j] + "  ");
            if (i == 3) {
                return;
            }
            j = j + 1 - result[i + 1][j];

        }
    }
}
