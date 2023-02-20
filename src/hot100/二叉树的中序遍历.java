package hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: EEGoose
 * @since: 2023-02-20 10:09
 */
public class 二叉树的中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fun(root, list);
        return list;
    }

    private void fun(TreeNode node, List<Integer> list){
        if (null == node) {
            return;
        }
        fun(node.left, list);
        list.add(node.val);
        fun(node.right, list);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

