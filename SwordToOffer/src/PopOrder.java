import java.util.LinkedList;

/**
 * Created by lichao on 18/07/2017.
 * 题目描述
 * 入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class PopOrder {
    public static boolean isPopOrder(){
        int[] pushA = new int[]{1, 2, 3, 4, 5};
        int[] popA = new int[]{4, 3, 5, 1, 2};
//        int[] popA = new int[]{3, 2, 1, 4, 5};

//        int[] pushA = new int[]{1};
//        int[] popA = new int[]{2};
        return f2(pushA, popA);

    }
    public static boolean f1(int[] pushA,int[] popA){
        LinkedList<Integer> stack = new LinkedList<>();
        int j = 0;
        for(int i = 0; i < popA.length; i++) {
            if (stack.isEmpty() || stack.peekLast() != popA[i]){//栈为空或栈顶元素不为popA

                for(; j < pushA.length; j++){
                    if(pushA[j] != popA[i]){
                        stack.addLast(pushA[j]);
                    }else{
                        break;
                    }
                }
                if (j >= popA.length){
                    return false;
                }
                j++;
            }else {
                stack.pollLast();
            }
        }
        return true;
    }
    public static boolean f2(int[] pushA,int[] popA){
        LinkedList<Integer> stack = new LinkedList<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.addLast(pushA[i]);
            while (!stack.isEmpty() && stack.peekLast() == popA[j]) {
                stack.pollLast();
                j++;
            }
        }
        return stack.isEmpty();
    }

}
