
/**
 * Created by lichao on 05/06/2017.
 * 100!
 */
public class P79 implements IAlgorithm{
    long result[] = new long[20];
    long d = 0;
    long temp;
    int index = 0;
    @Override
    public void exe() {
        int j = 0;
        result[0] = 1;
        for (int i = 2; i <= 100; i++) {
            for (j = 0; j <= index; j++) {
                temp = i * result[j] + d;
                result[j] = temp % 1000000000000000L;
                d = temp / 1000000000000000L;
                if (j == index && d != 0) {
                    index++;
                }
            }
        }
        if (d != 0) {
            result[j] = d;
        }
        j--;
        for (; j >= 0; j--) {
            String string = String.format("%015d",result[j]);
            System.out.print(string + "   ");
        }
    }
}
