/**
 * Created by lichao on 03/07/2017.
 * 找到第k小的数 利用快排算法了的思想
 */
public class P152 implements IAlgorithm {
    //    int data[] = {8, 2, 3, 4, 5, 6, 7, 1, 9, 10, 11, 12, 13, 14, 15};
//    int data[] = {8};
    int data[] = {8, 7, 6, 5, 4, 3, 2, 1};
    int k = 7;
    @Override
    public void exe() {
        System.out.println(getK(0, data.length - 1, k));
    }

    public int getK(int left, int right,int k) {
        if (left == right) {
            return data[left];
        }else{
            int temp = data[left];
            int i = left;
            int j = right;
            while (i < j) {
                while (i < j && data[j] >= temp) {
                    j--;
                }
                data[i] = data[j];
                while (i < j && data[i] <= temp) {
                    i++;
                }
            }
            data[j] = temp;
            if (j - left + 1 == k) {
                return data[j];
            } else if (j - left + 1 > k) {
                return getK(left, j, k);
            }else{
                return getK(j + 1, right, k - j + left - 1);
            }

        }
    }
}
