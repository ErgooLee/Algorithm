import java.util.stream.IntStream;

public class MergeSort {
    public static final int[] source = {5, 9, 8, 3, 7, 2, 10, 6, 19};

    public static void main() {
        sort(source, 0, source.length - 1);
        IntStream.of(source).forEach(System.out::print);
    }

    public static void sort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(data, left, mid);
            sort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    public static void merge(int[] data, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i, j, k = 0;
        for (i = left, j = mid + 1; i <= mid && j <= right;) {
            if (data[i] > data[j]) {
                temp[k++] = data[j++];
            }else{
                temp[k++] = data[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = data[i++];
        }
        while (j <= right) {
            temp[k++] = data[j++];
        }
        for (i = 0; i < k; i++) {
            data[i + left] = temp[i];
        }
    }

}
