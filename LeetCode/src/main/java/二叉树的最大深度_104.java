public class 二叉树的最大深度_104 {
    /**
     *          1
     *      2       7
     *  3       4
     *      5       6
     * */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
}
