/**
 * Created by lichao on 18/07/2017.
 */
public class HasSubtree {
    public static boolean HasSubtree(TNode root1, TNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }else{
            return judge(root1, root2, 0);
        }
    }

    private static boolean judge(TNode root1, TNode root2, int tag) {
        if(root1 == null && root2 == null){
            return true;
        }else if(root1 == null && root2 != null){
            return false;
        }else if(root1 != null && root2 == null){
            return true;
        }
        boolean result = false;
        if(root1.val == root2.val){
            result =  judge(root1.left, root2.left, 1) && judge(root1.right, root2.right, 1);
        }else if (tag == 1) {
            return false;
        }
        return result || judge(root1.left, root2, 0) || judge(root1.right, root2, 0);

    }

    public static class TNode {
        int val = 0;
        TNode left = null;
        TNode right = null;
        public TNode(int val) {
            this.val = val;
        }

        public TNode(int val, TNode left, TNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static TNode tNode4 = new TNode(4);
    public static TNode tNode7 = new TNode(7);
    public static TNode tNode9 = new TNode(9);
    public static TNode tNode2 = new TNode(2, tNode4, tNode7);
    public static TNode tNode8 = new TNode(8, tNode9, tNode2);
    public static TNode root1 = new TNode(8, tNode8, tNode7);

    public static TNode tNode29 = new TNode(9);
    public static TNode tNode22 = new TNode(2);
    public static TNode root2 = new TNode(8, tNode29, tNode22);


}
