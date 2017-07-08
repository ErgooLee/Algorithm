/**
 * Created by lichao on 03/07/2017.
 * 求第2小的数
 */
public class P151 implements IAlgorithm{
    int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14};

    @Override
    public void exe() {
        System.out.println(getMinTwo(0, data.length - 1).sm);
    }
    class Du{
        public int fm;
        public int sm;

        public Du(int fm, int sm) {
            this.fm = fm;
            this.sm = sm;
        }
    }

    public Du getMinTwo(int left, int right) {
        if (right - left == 1) {
            if (data[right] > data[left]) {
                return new Du(data[left], data[right]);
            } else {
                return new Du(data[right], data[left]);
            }
        }
        if (left == right) {
            return new Du(data[right], data[right]);
        }else{
            Du ldu = getMinTwo(left, (left + right) / 2);
            Du rdu = getMinTwo((left + right) / 2 + 1, right);

            int lfm = ldu.fm;
            int lsm = ldu.sm;
            int rfm = rdu.fm;
            int rsm = rdu.sm;

            int afm = 0;
            int asm;
            if (lfm > rfm) {
                afm = rfm;
                if (lfm > rsm && rsm != rfm) {
                    asm = rsm;
                }else
                    asm = lfm;
            }else {
                afm = lfm;
                if (rfm > lsm && lsm != lfm) {
                    asm = lsm;
                }else
                    asm = rfm;
            }
            return new Du(afm, asm);
        }
    }
}
