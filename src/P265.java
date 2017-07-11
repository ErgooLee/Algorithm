/**
 * Created by lichao on 11/07/2017.
 * 最大子段和问题  注意全是负数的情况。
 * 递归加动态规划
 */
public class P265 implements IAlgorithm {
//    int[] data = {-2, -1, -4, -7, -5, -2};
    int[] data = {-2, 11, -4, 13, -5, -20};
//    int[] data = {-2, 11, -4, 13, -5, -20,21};
//    int[] data = {-2, -1, -4, -3, -5, 0};
    @Override
    public void exe() {
//        Result result = recursive(0, data.length - 1);
//        System.out.println(result.sum);
//        System.out.println(result.begin);
//        System.out.println(result.end);
        noRecursive();
    }

    Result recursive(int begin, int end) {
        if (begin == end) {
            return new Result(begin,end,data[begin]);
        }else{
            int center = (begin + end) / 2;
            Result leftResult = recursive(begin, center);
            Result rightResult = recursive(center + 1, end);

            int leftMax = data[center];
            int leftBegin = center;
            int sum = data[center];
            for (int i = center - 1; i >=begin ; i--) {
                sum = sum + data[i];
                if (leftMax < sum) {
                    leftMax = sum;
                    leftBegin = i;
                }
            }

            int rightMax = data[center + 1];
            int rightEnd = center + 1;
            sum = data[center + 1];
            for (int i = center + 2; i <= end; i++) {
                sum = sum + data[i];
                if (rightMax < sum) {
                    rightMax = sum;
                    rightEnd = i;
                }
            }

            if (leftMax + rightMax >= leftResult.sum && leftMax + rightMax >= rightResult.sum) {
                return new Result(leftBegin, rightEnd, leftMax + rightMax);
            } else if (leftResult.sum >= leftMax + rightMax && leftResult.sum >= rightResult.sum) {
                return leftResult;
            }else{
                return rightResult;
            }
        }
    }

    class Result{
        public int begin;
        public int end;
        public int sum;
        public Result(int begin,int end,int sum){
            this.begin = begin;
            this.end = end;
            this.sum = sum;
        }
    }
    public void noRecursive(){
        int curSum = 0;
        int maxSum = 0;
        int bestI = 0;
        int bestJ = 0;
        int begin = 0;
        for (int i = 0; i < data.length; i++)
        {
            if (curSum + data[i] < 0) {
                curSum = 0;
                begin = i + 1;
            }
            else {
                curSum = curSum + data[i];
                if (curSum > maxSum) {
                    maxSum = curSum;
                    bestI = begin;
                    bestJ = i;
                }
            }

        }
        System.out.println(maxSum);
        System.out.println(bestI);
        System.out.println(bestJ);
    }
}
