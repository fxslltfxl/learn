package leetcode;

/**
 * @Author fxs
 * @Description //编程之美3.8：求二叉树中节点的最大距离
 * @Date 2019/11/27
 **/
public class MaxDistanceForBinaryTreeNode {


    public static void main(String[] args) {


    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static int maxDistanceForBinaryTreeNode(Node root) {
        if (root == null) {
            return 0;
        }
        int left = maxDistanceForBinaryTreeNode(root.left);
        int right = maxDistanceForBinaryTreeNode(root.right);
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int max = Math.max(left, right);
        int i = lHeight + rHeight + 1 + 1 - 1 - 1;
        return Math.max(max, i);
    }


    public class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
//写字楼里写字间，写字间里程序员；  
//程序人员写程序，又拿程序换酒钱。  
//酒醒只在网上坐，酒醉还来网下眠；  
//酒醉酒醒日复日，网上网下年复年。  
//但愿老死电脑间，不愿鞠躬老板前；  
//奔驰宝马贵者趣，公交自行程序员。  
//别人笑我忒疯癫，我笑自己命太贱；  
//不见满街漂亮妹，哪个归得程序员？ 