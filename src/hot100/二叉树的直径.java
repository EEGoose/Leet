package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-15 14:30
 */

public class 二叉树的直径 {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        int left = 0;
        if (root.left != null) {
            left = findDeepest(root.left, 1);
        }
        int right = 0;
        if (root.right != null) {
            right = findDeepest(root.right, 1);
        }

        int distance = left + right;

        if (distance > max) {
            max = distance;
        }

        return max;
    }

    private int findDeepest(TreeNode node, int level) {
        int left = level;
        if (node.left != null) {
            left = findDeepest(node.left, level + 1);
        }
        int right = level;
        if (node.right != null) {
            right = findDeepest(node.right, level + 1);
        }
        int distance = left - level + right - level;
        if (distance > max) {
            max = distance;
        }
        return left >= right ? left : right;
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