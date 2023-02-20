package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-20 10:59
 */
public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        fun(root);
        return root;
    }

    private void fun (TreeNode node) {
        if (node == null) {
            return;
        }
        fun(node.left);
        fun(node.right);
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.right = left;
        node.left = right;
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
