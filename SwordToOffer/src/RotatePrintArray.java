import java.util.ArrayList;

/**
 * Created by lichao on 18/07/2017.
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class RotatePrintArray {
    public static void display(int[][] matrix){
//        matrix = new int[][]{
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15},
//        };
//        matrix = new int[][]{
//                {1,2,3,4,5},
//        };
//        matrix = new int[][]{
//                {1,2,3,},
//                {4,5,6},
//                {7,8,9},
//                {10,11,12},
//        };
        matrix = new int[][]{
                {1}
        };
        f1(matrix);

    }
    static void f1(int[][] matrix){
        ArrayList<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int min = m > n ? n : m;
        int i = 0;
        for(i = 0; i < min / 2; i++){
            for(int x = i; x < n - 1 - i; x++){
                result.add(matrix[i][x]);
            }
            for(int x = i; x < m - 1 - i; x++){
                result.add(matrix[x][n - 1 - i]);
            }
            for(int x = i; x < n - 1 - i; x++){
                result.add(matrix[m - 1 - i][n - 1 - x]);
            }
            for(int x = i; x < m - 1 - i; x++){
                result.add(matrix[m - 1 - x][i]);
            }
        }
        if(min % 2 == 1){
            if(m > n){
                for(int j = i; j < m - i; j++){
                    result.add(matrix[j][i]);
                }
            }else{
                for(int j = i; j < n - i; j++){
                    result.add(matrix[i][j]);
                }
            }
        }
        System.out.println(result);
    }
    static void f2(int[][] matrix){

    }
}
