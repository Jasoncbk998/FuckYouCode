import java.util.Map;

public class 平衡二叉树_110 {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 基本思路
     * <p>
     * 是否平衡的标准就是
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * 如果root是null 则认为是平衡二叉树
     * 通过递归 不断判断一个节点每个子树的高度
     * isBalanced(root.left) && isBalanced(root.right); 这段代码保证了所有节点的每一个子树都平衡校验
     * 最终体现在高度差
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // 节点的高度
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}