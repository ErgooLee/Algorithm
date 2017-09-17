import java.util.Scanner;

public class MyGongShang {
    public static void main() {
        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int n = sc.nextInt();
        int a = 3;
        int b = 6;
        int n = 30;
        System.out.println(n / (a * b / gcd(a, b)));
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
}
