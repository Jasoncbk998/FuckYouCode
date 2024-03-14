package hot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 翻转二叉树_2226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree_1(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left = invertTree_1(root.left);
        TreeNode right = invertTree_1(root.right);
        root.left=left;
        root.right=right;
        return root;
    }

    public static void main(String[] args) {
        翻转二叉树_2226 test = new 翻转二叉树_2226();


    }
}
