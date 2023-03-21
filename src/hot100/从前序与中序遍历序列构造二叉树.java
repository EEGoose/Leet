package hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: EEGoose
 * @since: 2023-03-21 17:24
 */
public class 从前序与中序遍历序列构造二叉树 {
    public class TreeNode {
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

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return split(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode split(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart,
                           int inorderEnd) {
        if (preorderStart < 0 || preorderEnd >= preorder.length || preorderStart > preorderEnd) {
            return null;
        }
        if (preorderStart == preorderEnd) {
            return new TreeNode(preorder[preorderEnd]);
        }
        if (inorderStart < 0 || inorderEnd >= inorder.length || inorderStart > inorderEnd) {
            return null;
        }
        if (inorderStart == inorderEnd) {
            return new TreeNode(inorder[inorderStart]);
        }
        int root = preorderStart;
        TreeNode treeNode = new TreeNode(preorder[root]);
        int splitInOrderIndex = map.get(preorder[root]);
        int splitPreOrderIndex = preorderStart + splitInOrderIndex - inorderStart;

        treeNode.left =
                split(preorder, preorderStart + 1, splitPreOrderIndex, inorder, inorderStart, splitInOrderIndex - 1);
        treeNode.right = split(preorder, splitPreOrderIndex + 1, preorderEnd, inorder, splitInOrderIndex + 1,
                inorderEnd);
        return treeNode;
    }
}
