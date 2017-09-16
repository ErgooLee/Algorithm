import java.util.Scanner;

public class MyWangYi {
    private static String s;
    private static String t;
    private static int length;
    private static int[][] result;
    static char[] next;
    static int countLeft = 0;
    static int countRight = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        s = sc.next();
        s="(())";
        length = s.length();
        next = new char[length];
        int k = 0;
        int maxLength = 0;
        int count = 1;
        while (k >= 0) {
            f(k);
            while (next[k] !='e' && !check()) {
                f(k);
            }

            if (next[k] != 'e') {
                if (k == length - 1) {
                    String temp = String.valueOf(next);
                    if (!temp.equals(s)){
                        t = temp;
                        int n = exe();
                        if (n > maxLength) {
                            maxLength = n;
                            count = 1;
                        } else if (n == maxLength) {
                            count++;
                        }
                    }

                } else {
                    k = k + 1;
                    next[k] = 0;
                }
            } else {
                k = k - 1;
            }
        }
        System.out.println(count);
    }


    public static void f(int k){
        if (next[k]==0){
            next[k] = '(';
            countLeft++;
        }else if (next[k]=='('){
            next[k] = ')';
            countLeft--;
            countRight++;
        }else if(next[k]==')'){
            countRight--;
            next[k] = 'e';
        }
    }
    static boolean check(){
        if (countLeft <= length / 2 && countRight <= countLeft) {
            return true;
        }
        return false;
    }
    public static int exe() {
        result = new int[length + 1][length + 1];
        for (int i = 0; i< length + 1; i++) {
            for (int j = 0; j < length + 1; j++) {
                result[i][j] = -1;
            }
        }
        getMaxSub(length, length);
        return result[length][length];
    }

    public static int getMaxSub(int indexA, int indexB) {
        if (indexA == 0 || indexB == 0) {
            result[indexA][indexB] = 0;
        }
        else {
            if (s.charAt(indexA - 1) == t.charAt(indexB - 1)) {
                result[indexA][indexB] = getMaxSub(indexA - 1, indexB - 1) + 1;
            } else {
                int t1 = getMaxSub(indexA, indexB - 1);
                int t2 = getMaxSub(indexA - 1, indexB);
                if (t1 > t2) {
                    result[indexA][indexB] = t1;
                } else {
                    result[indexA][indexB] = t2;
                }
            }
        }
        return result[indexA][indexB];
    }
}
