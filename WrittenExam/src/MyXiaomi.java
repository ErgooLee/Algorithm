import java.util.ArrayList;

public class MyXiaomi {
    public static void main() {
        f3("ABCDE",10);
    }

    public static void f1() {
        String table = "10001";
        int n = 2;
        int index;
        int count = 0;
        for (int i = 0; i < table.length(); i++) {
            while (i < table.length() && table.charAt(i) == '1') {
                i++;
            }
            index = i;
            while (i < table.length() && table.charAt(i) == '0') {
                i++;
            }
            if (i == table.length()) {

                count += (i - index) / 2;
            } else {
                count += (i - index - 1) / 2;
            }
        }
        System.out.println(count >= n);
    }

    public static long f2(long x) {
        if (x == 1) {
            return x;
        }
        ArrayList<Long> array = new ArrayList<>();
        array.add(1L);
        array.add(1L);
        long index  = 2;
        while(true){
            index++;
            for (int i = (int)((index + 1) / 2 - 1); i > 0; i--) {

                if (i == array.size()) {
                    array.add(array.get(i - 1) * 2);
                } else {
                    array.set(i, array.get(i - 1) + array.get(i));
                }

            }
            if (array.contains(x)) {
                return index;
            }
        }
    }

    public static void f3(String drinks, int n) {
        int[] data = new int[7];
        for (int i = 0; i < drinks.length(); i++) {
            data[drinks.charAt(i) - 'A']++;
        }
        StringBuilder sb = new StringBuilder();
        int days = 0;
        int count = 0;
        int index = 0;
        int firstIndex = -1;
        int tempDay = 0;
        for (int i = 0; i < drinks.length(); i++) {
            while (data[index] == 0) {
                index = (index + 1) % 7;
            }
            if (firstIndex == -1) {
                firstIndex = index;
            }
            if (firstIndex == index){
                if (tempDay < n){
                    tempDay ++;
                    count ++;
                }else{
                    sb.append('A' + index);
                    data[index]--;
                    tempDay++;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
