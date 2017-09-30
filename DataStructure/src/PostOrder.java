import java.util.LinkedList;

/**
 * Created by lichao on 15/07/2017.
 */

public class PostOrder {

    public PostOrder(TreeNode root){
        postOrder1(root);
    }

    public void postOrder1(TreeNode root) {
        //很巧妙，但是很难想到啊。
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        TreeNode r = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.addLast(p);
                p = p.left;
            }
            p = stack.peekLast();
            if (p.right != null && p.right != r) {
                p = p.right;
            }else{
                r = p;
                System.out.print(p.val);
                stack.pollLast();
                p = null;
            }
        }
        System.out.println();
    }
}


