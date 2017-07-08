/**
 * Created by lichao on 07/07/2017.
 * 马的遍历问题
 */
public class P218 implements IAlgorithm {
    private int[][] result;
    int m = 8;
    int n = 8;
    int xx[] = {2, 1, -1, -2, -2, -1, 1, 2};
    int yy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    int startX = 0;
    int startY = 0;
    int total = 0;
    @Override
    public void exe() {
        result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
//        find(startX, startY,1);
        nonRecursive();
    }
    public void find(int x,int y,int depth){
        if (depth == 64) {
            result[x][y] = 64;
            out();
        }else {
            for (int i = 0; i < 8; i++) {
                if (check(x + xx[i], y + yy[i])) {
                    result[x][y] = depth;
                    find(x + xx[i], y + yy[i], depth + 1);
                }
            }
        }
        result[x][y] = -1;
    }


    public boolean check(int x,int y){
        if (x >= 0 && x < m && y >=0 && y < n && result[x][y] == -1) {
            return true;
        }
        return false;
    }
    public void out(){
        System.out.println();
        System.out.println("total " + ++total + ": ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%-3d", result[i][j]);
            }
            System.out.println();
        }
    }
    public void nonRecursive(){
        int depth = 0;
        result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = -1;
            }
        }
        int x = startX;
        int y = startY;
        while (depth >= 0) {
            int temp = result[x][y] + 1;
            result[x][y] = temp;
            while (result[x][y] < 8 && !check(x + xx[result[x][y]], y + yy[result[x][y]])) {
                temp = result[x][y] + 1;
                result[x][y] = temp;
            }
            if (result[x][y] < 8) {
                if (depth == m * n - 2 && result[x + xx[result[x][y]]][y + yy[result[x][y]]] == -1) {
                    out();
                } else {
                    depth++;
                    int newX = x + xx[result[x][y]];
                    int newY = y + yy[result[x][y]];
                    x = newX;
                    y = newY;
                }
            }else{
                result[x][y] = -1;
                depth--;
                int i;
                for (i = 0; i < 8; i++) {
                    int newX = x - xx[i];
                    int newY = y - yy[i];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (i == result[newX][newY]) {
                            x = newX;
                            y = newY;
                            break;
                        }
                    }
                }
                if (i == 8) {
                    System.out.println("done");
                    return;
                }
            }
        }
    }
}
