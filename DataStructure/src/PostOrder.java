import java.util.LinkedList;

/**
 * Created by lichao on 15/07/2017.
 */

public class PostOrder {

    public PostOrder(TreeNode root){
        postOrder1(root);
        postOrder2(root);
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


    public void postOrder2(TreeNode root){
        if (root == null) {
            return;
        }
        LinkedList<StackNode> stack = new LinkedList<>();
        TreeNode p = root;
        StackNode top = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.addLast(new StackNode(p));
                p = p.left;
            }
            top = stack.peekLast();
            if (top.isLeft) {
                p = top.node.right;
                top.isLeft = false;
            }else{
                System.out.print(top.node.val);
                stack.pollLast();
                p = null;
            }
        }
        System.out.println();
    }
}


class StackNode{
    public boolean isLeft = true;
    public TreeNode node;
    public StackNode(TreeNode node) {
        this.node = node;
    }
}
