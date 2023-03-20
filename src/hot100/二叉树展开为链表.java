package hot100;

/**
 * @author: EEGoose
 * @since: 2023-03-18 15:47
 */
public class 二叉树展开为链表 {
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

    public static void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        digui(root);
    }

    public static TreeNode digui(TreeNode root) {
        TreeNode left = root.left;
        TreeNode leftResult = null;
        if (null != root.left) {
            leftResult = digui(root.left);
        }
        TreeNode right = root.right;
        TreeNode rightResult = null;
        if (null != root.right) {
            rightResult = digui(root.right);
        }

        if (null != left) {
            root.left = null;
            root.right = left;
            left.left = null;
            if (null != leftResult) {
                leftResult.right = right;
            }
        }

        if (null != right) {
            return rightResult;
        } else if(null != left){
            return leftResult;
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root =
                new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5,
                        null, new TreeNode(6)));
        TreeNode root2 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, new TreeNode(5,
                new TreeNode(6), null), null),
                null), null), null);
        TreeNode root3 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(5), null),
                new TreeNode(4)), null);
        flatten(root3);
        System.out.println(true);
    }
}
