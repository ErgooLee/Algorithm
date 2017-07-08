/**
 * Created by lichao on 0/0/2017.
 * 素数环问题
 */
public class P220 implements IAlgorithm {
    boolean[] judge = {
            true,false,true,false,true,
            false,false,false,true,false,
            true,false,false,false,true,
            false,true,false,false,false,
            true,false,false,false,false,
            false,true,false,true,false,
            false,false,false,false,true,
            false,false};
    public int[] result = new int[21];
    public boolean[] visited = new boolean[21];
    int total = 0;
    @Override
    public void exe() {
        getK(1);
    }
    public void getK(int k){

        for (int i = 1; i <= 20; i++) {
            if (!visited[i] && check(k, i)) {
                visited[i] = true;
                result[k] = i;
                if (k == 20) {
                    System.out.printf("%-6d :", ++total);
                    for (int j = 1; j < 21; j++) {

                        System.out.printf("%4d", result[j]);
                    }
                    System.out.println();
                } else {
                    getK(k + 1);
                }
                visited[i] = false;
            }
        }
    }
    public boolean check(int k,int value){
        if (k == 1) {
            return true;
        } else if (k == 20) {
            return judge[value + result[k - 1] - 3] && judge[value + result[1] - 3];
        }else{
            return judge[value + result[k - 1] - 3];
        }
    }
}
