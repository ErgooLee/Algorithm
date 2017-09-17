import java.util.Scanner;
/**
 * 3 2 3
 *1 2 1
 *2 3 2
 *1 1
 *2 1
 *3 2
 *1 3
 */
public class MyDji {
    public static void main() {
        f2();
    }
    public static void f1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a  = sc.nextInt();
            int b = sc.nextInt();
            comb(a, b);
        }
    }
    public static void comb(int n, int r) {
        if (n == 0){
            System.out.println(0);
            return;
        }
        long a = 1;
        long b = 1;
        if (r > n / 2) {
            r = n - r;
        }
        for (int i = 0; i < r; i++) {
            a *= (n - i);
            b *= (r - i);
        }
        System.out.println(a / b);
    }



    public static void f2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int m = sc.nextInt();
        int INF = Integer.MAX_VALUE;
        int[][] Adjmatrix = new int[n][n];
        int[] mm = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Adjmatrix[i][j] = INF;
                if (i == j) {
                    Adjmatrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < l; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int dis = sc.nextInt();
            Adjmatrix[u][v] = dis;
            Adjmatrix[v][u] = dis;
        }
        for (int i = 0; i < m; i++) {
            sc.nextInt();
            mm[sc.nextInt() - 1]++;
        }
        int V = sc.nextInt() - 1;//假设   寻找所有顶点到0顶点的最短路径       这里可做为程序的接口
        int y = sc.nextInt() - 1;
        int[] Path = new int[n];//存放路径
        int[] Length = new int[n];//存放路径长度
        int[] S = new int[n];
        int u = 0;
        int temp = 0;
        for (int i = 0; i != n; i++) {

            if (Adjmatrix[V][i] != INF)//初始化Path
                Path[i] = V;
            else
                Path[i] = -1;
            Length[i] = Adjmatrix[V][i];//初始化Length
            S[i] = 0;//初始化S[]   全是零代表S中没有元素；
        }
        S[V]=1;
        for (int i = 0; i < n; i++)//外层循环找到所有顶点到V的最短路径
        {
            temp = INF;
            for (int j = 0; j < n; j++)//找出U中距离V最短的顶点为u
            {
                if (S[j] == 0 && Length[j] < temp) {
                    temp = Length[j];
                    u = j;
                }
            }
            S[u] = 1;//将u放进S中
            for (int j = 0; j < n; j++) {
                if (S[j] == 0)//S中的点不可能再通过u绕得更短
                    if ((Adjmatrix[u][j] != INF) && (Adjmatrix[u][j] + temp < Length[j]))//如果通过u使v到j的路径变短
                    {
                        Length[j] = Adjmatrix[u][j] + temp;//将v到j的路径修改
                        Path[j] = u;//将路径记录下来；
                    }
            }
        }
        int ln = Length[y];
        if (ln == INF) {
            System.out.println(-1);
        }else{
            System.out.println(ln);
            int count = 0;
            while (y != V) {
                count += mm[y];
                y = Path[y];
            }
            count += mm[y];
            System.out.println(count);
        }
    }
}
