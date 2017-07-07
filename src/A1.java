/**
 * Created by lichao on 28/06/2017.
 * 找出数组中超过一半的元素
 */
public class A1 implements IAlgorithm {
    @Override
    public void exe() {
        int size = 6;
        int[] array = {1,2,1,2,1,1};
        int index = 0;
        int next = 1;
        while (next < size) {
            if (array[index] != array[next]) {
                array[index] = 0;
                array[next] = 0;

                while (index >= 0) {
                    if (array[index] != 0) {
                        break;
                    }else{
                        index--;
                    }
                }
                if (index < 0) {
                    index = next + 1;
                    next = index + 1;
                }else{
                    next++;
                }
            }else{
                index = next;
                next++;
            }

        }
        if (index >= size) {
            System.out.println("no half number");
            return;
        }
        System.out.println(array[index]);
    }
}
