/**迈克喜欢在火车旅行的时候用手机听音乐，他有N首歌在手机里，
 * 在整个火车途中，他可以听P首歌，所以他想产生一个播放表产生P首歌曲，
 * 这个播放表的规则是：
 * 每首歌都要至少被播放一次
 * 在两首一样的歌中间，至少有M首其他的歌
 * 迈克在想有多少种不同的播放表可以产生，
 * 那么给你N,M,P，你来算一下，
 * 输出结果取1000000007的余数*/

public class PlayList {
    long[][] dp;
    int n,m,p;
    long mo = 1000000007;
    long dfs(int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == p) {
            if (j == n) {
                dp[i][j] = 1;
                return 1;
            } else {
                dp[i][j] = 0;
                return 0;
            }
        }
        dp[i][j]=0;
        if (j > m) {
            dp[i][j] = dfs(i + 1, j) * (j - m);
        }
        if (j < n) {
            dp[i][j] += dfs(i + 1, j + 1) * (n - j);
        }

        if (dp[i][j] >= mo) {
            dp[i][j] %= mo;
        }
        return dp[i][j];
    }

    public PlayList() {
        n = 5;
        m = 2;
        p = 7;
        dp = new long[p+1][n+1];
        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0, 0));
        for (int i = 0; i <= p; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.printf("%-10d" , dp[i][j]);
            }
            System.out.println();
        }
    }

}
