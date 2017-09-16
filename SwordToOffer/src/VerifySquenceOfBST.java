/**
 * Created by lichao on 18/07/2017.
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        return isSequenceOfBST(sequence, 0, sequence.length - 1);
    }
    private static boolean isSequenceOfBST(int[] sequence, int begin, int end){
        if(end - begin <= 2){
            return true;
        }
        int root = sequence[end];
        int index = end - 1;
        while(index >= begin && sequence[index] > root){
            index--;
        }
        int i = index;
        while(i >= begin && sequence[i] < root){
            i--;
        }
        if(i >= begin){
            return false;
        }
        return isSequenceOfBST(sequence, begin, index) && isSequenceOfBST(sequence, index + 1, end - 1);
    }
}
