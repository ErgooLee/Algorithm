
/**
 * Created by lichao on 05/06/2017.
 * 长整型*大数
 */
public class P78 implements IAlgorithm {
    @Override
    public void exe() {
        //result 9754610582488035250103033047
        String source = "98765432123456789";
        long mutiplier = 98765432123L;
        long d = 0,b = 0;
        char[] faciend = source.toCharArray();
        char[] result = new char[256];
        int length = source.length();
        int j = 0;
        for (int i = length - 1; i >= 0; i--) {
            b = mutiplier * (faciend[i] - '0') + d;
            result[j] = (char)(b % 10 + '0');
            d = b / 10;
            j++;
        }
        while (d != 0) {
            result[j] = (char)(d % 10 + '0');
            d = d / 10;
            j++;
        }
        for (int i = j - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }
    }
}
