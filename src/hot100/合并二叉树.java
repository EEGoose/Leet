package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-16 11:25
 */
public class 合并二叉树 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return link(root1, root2);
    }

    private TreeNode link(TreeNode node1, TreeNode node2) {
        TreeNode current = null;
        if (null == node1 && null == node2) {
            return null;
        }
        if (null != node1) {
            current = node1;
        } else {
            current = node2;
        }
        if (null != node1 && null != node2) {
            current.val = node1.val + node2.val;
        }
        current.left = link(node1 != null ? node1.left : null, node2 != null ? node2.left : null);
        current.right = link(node1 != null ? node1.right : null, node2 != null ? node2.right : null);
        return current;
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
