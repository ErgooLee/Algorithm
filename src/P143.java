/**
 * Created by lichao on 30/06/2017.
 * 残缺棋盘问题
 */
public class P143 implements IAlgorithm {
    private int amount = 0;
    private int[][] result = new int[100][100];
    @Override
    public void exe() {
        int k = 3;

        int x=1,y=0;
        cal(0, 0, x, y, k);
        int num = 1<<k;
        System.out.println(num);
        for (int i = 0; i < num; i++) {
            for (int j = 0;j<num;j++) {
                System.out.printf("%-4d",result[i][j]);
            }
            System.out.println();
        }
    }
    public void cal(int x,int y,int xx,int yy,int size){
        if (size < 1) {
            return;
        }
        amount++;
        int next = amount;
        int xxx = 1 << (size - 1);
        int midX = x + xxx;
        int midY = y + xxx;
        if (xx < midX && yy < midY) {
            cal(x, y, xx, yy, size - 1);
            cal(x, midY, midX - 1, midY, size - 1);
            cal(midX, y, midX, midY - 1, size - 1);
            cal(midX, midY, midX, midY, size - 1);
            result[midX - 1][midY] = next;
            result[midX][midY - 1] = next;
            result[midX][midY] = next;
        } else if (xx < midX && yy >= midY) {

            cal(x, y, midX - 1, midY - 1, size - 1);
            cal(x, midY, xx, yy, size - 1);
            cal(midX, y, midX, midY - 1, size - 1);
            cal(midX, midY, midX, midY, size - 1);
            result[midX -1 ][midY - 1] = next;
            result[midX][midY - 1] = next;
            result[midX][midY] = next;
        } else if (xx >= midX && yy < midY) {
            cal(x, y, midX - 1, midY - 1, size - 1);
            cal(x, midY, midX - 1, midY, size - 1);
            cal(midX, y, xx, yy, size - 1);
            cal(midX, midY, midX, midY, size - 1);
            result[midX -1 ][midY - 1] = next;
            result[midX - 1][midY] = next;
            result[midX][midY] = next;
        }else{
            cal(x, y, midX - 1, midY - 1, size - 1);
            cal(x, midY, midX - 1, midY, size - 1);
            cal(midX, y, midX, midY - 1, size - 1);
            cal(midX, midY, xx, yy, size - 1);
            result[midX -1 ][midY - 1] = next;
            result[midX][midY - 1] = next;
            result[midX - 1][midY] = next;
        }
    }

}
