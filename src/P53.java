import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichao on 03/06/2017.
 * 找到1000以内的所有完数，所有因子的和与自身相等，称为完数。
 */
public class P53 implements IAlgorithm {
    @Override
    public void exe() {
        List array = new ArrayList<Integer>();
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            array.clear();
            sum = 1;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    sum += j;
                    sum += i / j;
                    array.add(j);
                    array.add(i / j);
                }
            }
            if (sum == i) {
                StringBuffer out = new StringBuffer(i + " it's factors are 1");
                for (int z = 0; z < array.size(); z++) {
                    out.append(",").append(array.get(z));
                }
                System.out.println(out);
            }
        }
    }
}
