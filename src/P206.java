/**
 * Created by lichao on 06/07/2017.
 * 七巧板着色问题  深度优先
 */
public class P206 implements IAlgorithm {
    private int[][] data = new int[][]{
            {0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 1, 1, 0, 0}
    };
    private int[] result = new int[7];
    private int total = 0;
    private int totalCol = 4;
    @Override
    public void exe() {
        dfs(0);
    }

    public void dfs(int who) {
        if (who >= 7) {
            total = total + 1;
            System.out.print(total + ":  ");
            out();
            return;
        }
        for (int i = 0; i < totalCol; i++) {
            if (check(who, i)) {
                result[who] = i;
                dfs(who + 1);
            }

        }
    }

    public boolean check(int who, int color) {
        for (int i = 0; i < who; i++) {
            if (data[i][who] == 1 && color == result[i]) {
                return false;
            }
        }
        return true;
    }
    private void out(){
        for (int i : result) {
            System.out.printf("%-3d", i);
        }
        System.out.println();
    }
}
