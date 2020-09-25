package arithmetic.tree;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/12/30
 **/
public class BinarySearchTreeToGreatSumTree {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(2);
        TreeNode treeNode4 = new TreeNode(3);

        treeNode.left = treeNode1;

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.right = treeNode4;

        inOrder(treeNode);
        System.out.println();
    }

    static HashMap<TreeNode, Integer> cache = new HashMap<>();


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode bstToGst(TreeNode root) {
        inOrder(root);
        int sum = 0;
        for (TreeNode node : list) {
            sum += node.val;
            node.val = sum;
        }
        return root;
    }
    static ArrayList<TreeNode> list = new ArrayList<>();

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.right);
        list.add(root);
        inOrder(root.left);
    }

    /**
     * 每个节点 所有子节点与本身值得的和
     *
     * @param root
     * @return
     */
    private static int value(TreeNode root) {
        if (cache.get(root) != null) {
            return cache.get(root);
        } else {
            int sum = root.val;
            if (root.left != null) {
                sum += value(root.left);
            }
            if (root.right != null) {
                sum += value(root.right);
            }
            cache.put(root, sum);
            root.val = sum;
            return sum;
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