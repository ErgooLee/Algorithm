/**
 * Created by lichao on 04/07/2017.
 * 资源分配问题  动态规划
 */
public class P171 implements IAlgorithm {
    @Override
    public void exe() {
        int totalMoney = 7;
        int totalItem = totalMoney + 1;
        int totalProject = 3;
        float[][] table = {
                {0, 0.11f, 0.13f, 0.15f, 0.21f, 0.24f, 0.30f, 0.35f},
                {0, 0.12f, 0.16f, 0.21f, 0.23f, 0.25f, 0.24f, 0.34f},
                {0, 0.08f, 0.12f, 0.20f, 0.24f, 0.26f, 0.30f, 0.35f}};

        float[] maxTable = new float[totalItem];
        float[] newMaxTable = new float[totalItem];

        int path[][] = new int[totalProject - 1][totalItem];

        float temp[] = new float[totalItem];

        for (int i = 0; i < totalItem; i++) {

            maxTable[i] = table[0][i];
        }

        for (int nextProject = 1; nextProject < totalProject; nextProject++) {

            for (int moneyforAB = 1; moneyforAB <= totalMoney; moneyforAB++) {
                for (int moneyforA = 0; moneyforA <= moneyforAB; moneyforA++) {
                    temp[moneyforA] = maxTable[moneyforA] + table[nextProject][moneyforAB - moneyforA];
                }
                float maxValue = temp[0];
                int maxValueIndex = 0;
                for (int i = 1; i <= moneyforAB; i++) {
                    if (maxValue < temp[i]) {
                        maxValue = temp[i];
                        maxValueIndex = i;
                    }
                }
                newMaxTable[moneyforAB] = maxValue;
                path[nextProject - 1][moneyforAB] = maxValueIndex;
            }
            float[] p = maxTable;
            maxTable = newMaxTable;
            newMaxTable = p;
            for (int i = 0; i < totalItem; i++) {

                System.out.printf("%7.2f", newMaxTable[i]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0;i<totalItem;i++) {
            System.out.printf("%7.2f",maxTable[i]);
        }
        System.out.println();

        for (int i = 0; i < totalProject - 1; i++) {
            for (int j = 0;j<totalItem;j++) {
                System.out.printf("%4d",path[i][j] );
            }
            System.out.println(  );
        }

        System.out.println();
        int j = totalMoney;
        for (int i = totalProject - 2; i >= 0; i--) {

            System.out.printf("%d", totalMoney - path[i][j]);
            totalMoney = path[i][j];
            j = path[i][j];
            System.out.println();
        }
        System.out.println(totalMoney);

    }
}