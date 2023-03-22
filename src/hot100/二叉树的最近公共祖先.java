package hot100;

/**
 * @author: EEGoose
 * @since: 2023-03-22 19:59
 */
public class 二叉树的最近公共祖先 {
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

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        digui(root, p, q);
        return ans;
    }

    private boolean digui(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = digui(root.left, p, q);
        boolean right = digui(root.right, p, q);
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            ans = root;
        }
        return left || right || root.val == p.val || root.val == q.val;
    }

}
