import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by lichao on 18/07/2017.
 */
public class FindPath {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        int currentSum = 0;
        if(root == null){
            return result;
        }
        TreeNode p = root;
        TreeNode r = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.addLast(p);
                currentSum = currentSum + p.val;
                p = p.left;
            }
            p = stack.peekLast();
            if (p.right != null && p.right != r) {
                p = p.right;
            }else{
                if (currentSum == target){
                    ArrayList<Integer> list = new ArrayList<>();
                    for (TreeNode item : stack){
                        list.add(item.val);
                    }
                    result.add(list);
                }
                stack.pollLast();
                currentSum = currentSum - p.val;
                r = p;
                p = null;
            }

        }
        return result;
    }
}
