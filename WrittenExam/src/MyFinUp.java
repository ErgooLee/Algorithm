import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class MyFinUp {
    public static void main() {
        f2();
    }

    public static void f1() {
        Scanner sc = new Scanner(System.in);
        int record[] = new int[10];

        int n = sc.nextInt();
        n++;
        int temp;
        int a;
        boolean find = true;
        while(true){
            temp = n;
            find = true;
            while (temp != 0) {
                a = temp % 10;
                if (record[a] == 1) {
                    find = false;
                    break;
                }else{
                    record[a]++;
                }
                temp = temp / 10;
            }
            if (find) {
                System.out.println(n);
                break;
            }else{
                n++;
                for (int i = 0;i<10;i++) {
                    record[i] = 0;
                }
            }
        }
    }

    public static void f2() {
        Scanner sc = new Scanner(System.in);
        List<HashSet<Integer>> list = new ArrayList<>();
        int n = sc.nextInt();
        int next = 0;
        HashSet set1 = null;
        HashSet set2 = null;
        for (int i = 1; i <= n; i++) {
            next = sc.nextInt();
            if (list.isEmpty()) {
                HashSet<Integer> set = new HashSet<>();
                set.add(i);
                set.add(next);
                list.add(set);
            }else{
                set1 = null;
                set2 = null;
                for (HashSet set : list) {
                    if (set.contains(i) || set.contains(next)) {
                        set.add(i);
                        set.add(next);
                        if (set1 == null) {
                            set1 = set;
                        }else{
                            set2 = set;
                        }
                    }
                }
                if (set1 == null) {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(next);
                    list.add(set);
                }
                if (set2 != null) {
                    set1.addAll(set2);
                    list.remove(set2);
                }
            }
        }
        System.out.println(list.size());
    }
}


