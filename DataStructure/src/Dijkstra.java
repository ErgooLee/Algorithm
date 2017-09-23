
public class Dijkstra {
    public static void main() {
        int nodeNum = 7;
        int INF = Integer.MAX_VALUE;
        int[][] Adjmatrix = {
                {0, 4, 6, 6, INF, INF, INF},//邻接矩阵
                {INF, 0, 1, INF, nodeNum, INF, INF},
                {INF, INF, 0, INF, 6, 4, INF},
                {INF, INF, 2, 0, INF, 5, INF},
                {INF, INF, INF, INF, 0, INF, 6},
                {INF, INF, INF, INF, 1, 0, 8},
                {INF, INF, INF, INF, INF, INF, 0}};
        int[] path = new int[nodeNum];//存放路径
        int[] length = new int[nodeNum];//存放路径长度
        int S[] = new int[nodeNum];//S集合  初始为空
        int V = 0;
        int u = 0;
        int min = 0;
        for (int i = 0; i < nodeNum; i++) {
            if (Adjmatrix[V][i] != INF)//初始化path
                path[i] = V;
            else
                path[i] = -1;
            length[i] = Adjmatrix[V][i];//初始化length
        }
        S[V] = 1;//将V加入S集合
        for (int i = 1; i < nodeNum; i++)//外层循环找到所有顶点到V的最短路径
        {
            min = INF;
            for (int j = 0; j < nodeNum; j++)//找出U中距离V最短的顶点为u
            {
                if (S[j] == 0 && length[j] < min) {
                    min = length[j];
                    u = j;
                }
            }
            S[u] = 1;//将u放进S中
            for (int j = 0; j < nodeNum; j++) {
                if (S[j] == 0) {//S中的点不可能再通过u绕得更短
                    if ((Adjmatrix[u][j] != INF) && (Adjmatrix[u][j] + min < length[j]))//如果通过u使v到j的路径变短
                    {
                        length[j] = Adjmatrix[u][j] + min;//将v到j的路径修改
                        path[j] = u;//将路径记录下来；
                    }
                }
            }
        }
        for (int i = 0; i < nodeNum; i++) {
            System.out.printf("%3d",path[i]);
        }
        System.out.println();
        for (int i = 0; i < nodeNum; i++) {
            System.out.printf("%3d",length[i]);
        }
    }
}
