import java.util.LinkedList;

/**
 * Created by lichao on 14/07/2017.
 */
public class InOrder {
    public void inOrder(TreeNode root){
        if (root == null) {
            return;
        }
        TreeNode p = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.addLast(p);
                p = p.left;
            }
            p = stack.pollLast();
            System.out.print(p.val);
            p = p.right;
        }
        System.out.println();
    }

    public InOrder(TreeNode root){
        inOrder(root);
    }
}
