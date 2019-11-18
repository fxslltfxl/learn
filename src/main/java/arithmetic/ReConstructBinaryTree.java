package arithmetic;

public class ReConstructBinaryTree {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};

        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};


        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println("--------先续遍历（开始）---------");
        preOrder(treeNode);
        System.out.println("--------先续遍历（结束）---------");
        System.out.println("---------------------------");
        System.out.println("--------中序遍历（开始）---------");
        inOrder(treeNode);
        System.out.println("--------中序遍历（结束）---------");

    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || (pre.length != in.length)) {
            return null;
        }
        return reConstructBinaryTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
    }


    /**
     * @param pre
     * @param in
     * @param preStart
     * @param preEnd
     * @param inStart
     * @param inEnd
     * @return
     */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in, int preStart, int preEnd, int inStart,
                                                 int inEnd) {

        TreeNode root = new TreeNode(pre[preStart]);

        int rootIndex = 0;
        //找根节点在中序遍历数组的位置
        for (; rootIndex < in.length; rootIndex++) {
            if (in[rootIndex] == root.val)
                break;
        }
        //找中root节点对应的左右子树的长度
        int leftLength = rootIndex - inStart;

        int rightLength = inEnd - rootIndex;

        if (leftLength > 0) {
            root.left = reConstructBinaryTree(pre, in, preStart + 1, preStart + 1 + leftLength - 1, inStart,
                    rootIndex - 1);
        }
        if (rightLength > 0) {
            root.right = reConstructBinaryTree(pre, in, preStart + 1 + leftLength - 1 + 1, preEnd, rootIndex + 1,
                    inEnd);
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    static void preOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.println(treeNode.val);
            preOrder(treeNode.left);
            preOrder(treeNode.right);
        }

    }

    static void inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.left);
            System.out.println(treeNode.val);
            inOrder(treeNode.right);
        }

    }


}
