import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * Created by lichao on 17/07/2017.
 */
public class ReorderArray {
    public static void reOrderArray(int[] array) {
//        ArrayList<Integer> oddList = new ArrayList<>();
//        int index = 0;
//        while ((index < array.length) && array[index] % 2 == 1) {
//            index++;
//        }
//        if (index < array.length) {
//            oddList.add(array[index]);
//            int nextIndex = index;
//            int i = index + 1;
//            while (i < array.length) {
//                if (array[i] % 2 == 1){
//                    array[nextIndex] = array[i];
//                    nextIndex++;
//                }else{
//                    oddList.add(array[i]);
//                }
//                i++;
//            }
//            for (int item : oddList) {
//                array[nextIndex++] = item;
//            }
//        }

        int index = 0;
        while(index < array.length){
            while ((index < array.length) && array[index] % 2 == 0) {
                index++;
            }
            if (index < array.length) {
                int temp = array[index];
                int i = index - 1;
                while(i >= 0 && array[i] % 2 == 0){
                    array[i + 1] = array[i];
                    i--;
                }
                array[++i] = temp;
                index++;
            }
        }
    }
}
