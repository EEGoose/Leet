package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-17 10:50
 */
public class 二叉树最大深度 {
    private int max = 0;

    public int maxDepth(TreeNode root) {
        findDeeper(root, 1);
        return max;
    }

    private void findDeeper(TreeNode node, int level) {
        if (null == node) {
            return;
        }
        if (level > max) {
            max = level;
        }
        findDeeper(node.left, level + 1);
        findDeeper(node.right, level + 1);
    }

    static class TreeNode {
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
