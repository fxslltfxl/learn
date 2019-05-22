package leetcode;

public class SameTree {

    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
    }

    public static boolean isSameTreeWithoutString(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val) && (isSameTreeWithoutString(p.left, q.left) && (isSameTreeWithoutString(p.right,
                q.right)));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        preOrderTraverse(p);
        String s = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        preOrderTraverse(q);
        String s1 = stringBuilder.toString();
        return s.equals(s1);
    }

    private static void preOrderTraverse(TreeNode treeNode) {
        if (treeNode != null) {
            stringBuilder.append(treeNode.val);
            preOrderTraverse(treeNode.left);
            preOrderTraverse(treeNode.right);
        } else {
            stringBuilder.append("null");
        }
    }

    private static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
