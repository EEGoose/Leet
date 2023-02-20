package hot100;

/**
 * @author: EEGoose
 * @since: 2023-02-16 19:26
 */
public class 对称二叉树 {
    public static boolean isSymmetric(TreeNode root) {
        return symmetric(root.left, root.right);
    }

    private static boolean symmetric(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        } else if (null == left || null == right) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        if (!symmetric(left.left, right.right)) {
            return false;
        }
        return symmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two1 = new TreeNode(2);
        TreeNode two2 = new TreeNode(2);
        TreeNode three1 = new TreeNode(3);
        TreeNode three2 = new TreeNode(3);
        TreeNode four1 = new TreeNode(4);
        TreeNode four2 = new TreeNode(4);
        one.left = two1;
        one.right = two2;
        two1.left = three1;
        two1.right = four1;
        two2.left = four2;
        two2.right = three2;
        System.out.println(isSymmetric(one));
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
