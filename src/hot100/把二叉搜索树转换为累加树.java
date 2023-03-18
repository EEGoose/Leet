package hot100;

/**
 * @author: EEGoose
 * @since: 2023-03-18 14:57
 */
public class 把二叉搜索树转换为累加树 {
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

    public TreeNode convertBST(TreeNode root) {
        if (null == root) {
          return null;
        }
        digui(root, 0);
        return root;
    }

    private int digui(TreeNode treeNode, int num) {
        int count = treeNode.val;
        if (null != treeNode.right) {
            count += digui(treeNode.right, num);
            num = 0;
        }
        count += num;
        treeNode.val = count;
        if (null != treeNode.left) {
            return digui(treeNode.left, count);
        }
        return count;
    }
}
