import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class PackageProbolem {

    public static void main() {
        multiplePackWithRecord();
    }

    public static int onePackWithRecord(int N, int WEIGHT, int[] goodsWeight, int[] goodsValue,int[] result){//动态规划   01 背包  有解记录
        int[][] record = new int[N + 1][WEIGHT + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= WEIGHT; j++) {
                if (j < goodsWeight[i - 1] || record[i - 1][j] > record[i - 1][j - goodsWeight[i - 1]] + goodsValue[i - 1]){
                    record[i][j] = record[i - 1][j];
                } else{
                    record[i][j] = record[i - 1][j - goodsWeight[i - 1]] + goodsValue[i - 1];
                }
            }
        }
        int i = N;
        int j = WEIGHT;
        while (i > 0) {
            if (record[i][j] != record[i - 1][j]){
                result[i - 1] = 1;
                j = j - goodsWeight[i - 1];
            }
            i--;
        }
        return record[N][WEIGHT];
    }

    public static void onePackNoRecord(int N, int WEIGHT, int[] goodsWeight, int[] goodsValue) { // 01背包无解记录
        int[] record = new int[WEIGHT + 1];
        for (int i = 0; i < N; i++) {
            for (int j = WEIGHT; j >= goodsWeight[i]; j--) {
                if (record[j] < record[j - goodsWeight[i]] + goodsValue[i]){
                    record[j] = record[j - goodsWeight[i]] + goodsValue[i];
                }
            }
        }
        System.out.println("max value is " + record[WEIGHT]);
    }

    public static void f8() {//完全背包  无解记录
        int[] record = new int[WEIGHT + 1];
        for (int i = 0; i < N; i++) {
            for (int j = goodsWeight[i]; j <= WEIGHT; j++) {
                if (record[j] < record[j - goodsWeight[i]] + goodsValue[i]){
                    record[j] = record[j - goodsWeight[i]] + goodsValue[i];
                }
            }
        }
        System.out.println("max value is " + record[WEIGHT]);
    }


    public static void multiplePackWithRecord(){//多重背包  有记录
        int KINDS_OF_GOODS = 3;
        int WEIGHT = 6;
        int[] perWeight = {2, 3, 1};
        int[] perValue = {2, 3, 4};
        int[] numArray = {5, 8, 1};

        int[] divide = new int[KINDS_OF_GOODS];
        List<Integer> weightList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        for (int i = 0; i < KINDS_OF_GOODS; i++) {//拆包
            int num = numArray[i];
            int k = 1;
            while (true) {
                num = num - k;
                weightList.add(perWeight[i] * k);
                valueList.add(perValue[i] * k);
                k = k << 1;
                divide[i]++;
                if (num < k) {
                    if (num != 0) {
                        weightList.add(perWeight[i] * num);
                        valueList.add(perValue[i] * num);
                        divide[i]++;
                    }
                    break;
                }
            }
        }
        int N = weightList.size();
        int[] weight = new int[N];
        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            weight[i] = weightList.get(i);
            value[i] = valueList.get(i);
        }
//        onePackNoRecord(N,WEIGHT,weight,value);//非记录

        //输出记录
        int[] result = new int[N];
        System.out.println(onePackWithRecord(N, WEIGHT, weight, value, result));
        int[] reallyResult = new int[KINDS_OF_GOODS];
        int i = 0, j = 0;
        for (; i < KINDS_OF_GOODS; i++) {
            int temp = divide[i];
            while (temp > 1) {
                reallyResult[i] += (1 << (divide[i] - temp)) * result[j++];
                temp--;
            }
            reallyResult[i] += (numArray[i] - (1 << (divide[i] - temp)) + 1) * result[j++];
        }
        System.out.println(Arrays.toString(reallyResult));
    }









    public static void judgePackCanBeFulled() {//判断背包是否可以被装满
        System.out.println(f11(WEIGHT,N - 1));
    }

    static boolean f11(int restCapacity ,int n) {
        if (restCapacity == 0) {
            return true;
        } else if (restCapacity < 0 || (restCapacity > 0 && n < 0)) {
            return false;
        } else {
            if (f11(restCapacity - goodsWeight[n], n - 1)) {
                return true;
            } else {
                return f11(restCapacity, n - 1);
            }
        }
    }

    public static void f2() {//拆零背包  求最大利润  有货物选取记录
        double bestValue = 0;
        List<Node2> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new Node2(i, goodsWeight[i], goodsValue[i]));
        }
        Collections.sort(list,(node1,node2)->{
            return (int) ((double) node2.allValue / node2.weight - (double) node1.allValue / node1.weight);});
        for (Node2 node2 : list) {
            if (node2.weight > WEIGHT) {
                System.out.println(node2.id + ":" + WEIGHT + " ");
                bestValue = bestValue + WEIGHT * node2.allValue / node2.weight;
                break;
            }else{
                System.out.println(node2.id + ":" + node2.weight + " ");
                bestValue = bestValue + node2.weight * node2.allValue / node2.weight;
                WEIGHT = WEIGHT - node2.weight;
            }
        }
        System.out.println(bestValue);
    }
    static class Node2{
        int id;
        int weight;
        int allValue;

        public Node2(int id, int weight, int allValue) {
            this.id = id;
            this.allValue = allValue;
            this.weight = weight;
        }
    }
    static void f3(){//非拆零背包  求最大利润  无货物选取记录
        System.out.println(f33(WEIGHT, N - 1));
        System.out.println(Arrays.toString(record));
    }

    static int f33(int capacity, int n) {
        if (capacity <= 0 || (capacity > 0 && n < 0)) {
            return 0;
        }else{
            int a =0;
            if (capacity >= goodsWeight[n]){
                a = f33(capacity - goodsWeight[n], n - 1) + goodsValue[n];
            }
            int b = f33(capacity, n - 1);
            return a >= b ? a : b;
        }
    }

    public static void f4(int k) {//非拆零背包  求最大利润  有货物记录  没有分支限界
        if (k == N) {
            getABetter();
            return;
        }
        record[k] = 0;
        f4(k + 1);
        if (restCap >= goodsWeight[k]) {
            record[k] = 1;
            restCap -= goodsWeight[k];
            f4(k + 1);
            restCap = restCap + goodsWeight[k];
            record[k] = 0;
        }
    }

    public static void getABetter(){
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += record[i] * goodsValue[i];
        }
        if (sum > bestValue) {
            bestValue = sum;
            for (int i = 0; i < N; i++) {
                best[i] = record[i];
            }
        }
    }

    public static void f5(){//非递归 非拆零背包  求最大利润  有货物记录  没有分支限界
        int k = 0;
        record[k] = -1;
        while (k >= 0) {
            record[k]++;
            if (record[k] == 0 || record[k] == 1) {
                restCap = restCap - record[k] * goodsWeight[k];
                if (restCap >= 0) {
                    if (k == N - 1) {
                        getABetter();
                    }else{
                        k++;
                        record[k] = -1;
                    }
                }else{
                    restCap = restCap + record[k] * goodsWeight[k];
                    record[k] = -1;
                    k--;
                }
            } else {
                restCap = restCap + (record[k] - 1) * goodsWeight[k];
                record[k] = -1;
                k--;
            }
        }
    }

    static int N = 5;
    static int WEIGHT = 13;
    static int[] goodsWeight = {2, 2, 6, 5, 4};
    static int[] goodsValue = {6, 3, 5, 4, 6};

    static int[] record = new int[N];
    static int[] best = new int[N];
    static int bestValue = 0;
    static int restCap = WEIGHT;
}
