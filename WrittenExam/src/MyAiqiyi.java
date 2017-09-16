public class MyAiqiyi {
    public static void f2() {
        String s = "(()())";
        int max = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                countL++;
                if (countL > max) {
                    max = countL;
                }
            }else{
                countL--;
            }
        }
        System.out.println(max);
    }

    public static void f1() {
        int x1 = 1010;
        int k1 = 3;
        int x2 = 101010;
        int k2 = 2;
        String s1 = String.valueOf(x1);
        String s2 = String.valueOf(x2);
        if (s1.length() * k1 > s2.length() * k2) {
            System.out.println("Greater");
        } else if (s1.length() * k1 < s2.length() * k2) {
            System.out.println("Less");
        } else {
            int temp = s1.length() * s2.length() / gcd(s1.length(), s2.length());
            int t1 = temp / s1.length();
            int t2 = temp / s2.length();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < t1; i++) {
                sb1.append(s1);
            }
            for (int i = 0; i < t2; i++) {
                sb2.append(s2);
            }
            int result = sb1.toString().compareTo(sb2.toString());
            if (result > 0) {
                System.out.println("Greater");
            } else if (result == 0) {
                System.out.println("Equal");
            }else{
                System.out.println("Less");
            }
        }
    }
    static int gcd(int a, int b) {//最大公约数
        int k = 0;
        do {
            k = a % b;// 得到余数
            a = b;// 根据辗转相除法,把被除数赋给除数
            b = k;// 余数赋给被除数
        } while (k != 0);
        return a;
    }
    static void f3(){
        int n = 8;
        int m = 8;
        int i = 1;
        int j = 1;
        int count = 0;

        for (i = 1; i <= 8; i++) {
            for (j = 1; j <= m; j++) {
                double temp = Math.sqrt(i * j);
                if (temp - (int) temp == 0) {
                    count++;
                    System.out.println(i+":"+j);
                }
            }
        }
        System.out.println(count);
    }
}
