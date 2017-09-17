import java.util.LinkedList;

/**
 * Created by lichao on 14/07/2017.
 */
public class PreOrder {

    public PreOrder(TreeNode root){
        preOrder1(root);
    }

    public void preOrder1(TreeNode root){
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                System.out.print(p.val);
                stack.addLast(p);
                p = p.left;
            }
            p = stack.pollLast();
            p = p.right;
        }
        System.out.println();
    }

}
