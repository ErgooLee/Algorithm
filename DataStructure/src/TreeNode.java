/**
 * Created by lichao on 14/07/2017.
 */
public class TreeNode {
    public TreeNode left = null;
    public TreeNode right = null;
    public int val;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public TreeNode(int val) {
        this.val = val;
    }

    public static final TreeNode root1 = new TreeNode(0,
            null,
            null);

    public static final TreeNode root2 = new TreeNode(0,
            new TreeNode(1, null, null),
            null);

    public static final TreeNode root3 = new TreeNode(0,
            null,
            new TreeNode(1, null, null));

    public static final TreeNode root4 = new TreeNode(0,
            new TreeNode(1, null, null),
            new TreeNode(2, null, null));

    public static final TreeNode root5 = new TreeNode(0,
            new TreeNode(1,
                    new TreeNode(3,
                            new TreeNode(5,null,null),
                            null),
                    new TreeNode(4,null,null)),
            new TreeNode(2,null,null));
}