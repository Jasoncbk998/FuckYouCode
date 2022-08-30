public class _110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);
        return Math.abs(leftHeight-rightHeight)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
