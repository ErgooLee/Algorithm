/**
 * Created by lichao on 16/07/2017.
 * 大根堆排序
 */
public class HeapSort {
    private int[] data = new int[]{0, 53, 17, 78, 9, 45, 65, 87, 32};

    public HeapSort(){
        heapSort(data.length - 1);
        for (int i = data.length - 1; i > 0; i--) {
            int temp = data[i];
            data[i] = data[1];
            data[1] = temp;
            for (int j = 1; j < data.length; j++) {
                System.out.printf("%-4d",data[j]);
            }
            heapSort(i - 1);
            System.out.println();
        }
    }
    public void heapSort(int length){
        int k;
        for(int i = length / 2; i > 0; i--) {
            data[0] = data[i];
            k = i;
            for (int j = 2 * k; j <= length; j = j * 2) {
                if (j < length && data[j] < data[j + 1]) {
                    j++;
                }
                if (data[0] < data[j]) {
                    data[k] = data[j];
                    k = j;
                }
            }
            data[k] = data[0];
        }
    }
}
