package arithmetic.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author fxs
 * @Description 求二叉树中节点的最大距离
 * 1
 * / \
 * 2   3
 * / \
 * 4  5
 * @Date 2019/11/25
 **/
public class MaxDistance {
    public static void main(String[] args) {

    }

    TreeNode res = null;

    class TreeNode {
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        int value;
        int MaxLeft;
        int MaxRight;
    }

    void maxDistance(TreeNode root) {



        if (root == null) {
            return;
        }
        if (root.left == null) {
            root.MaxLeft = 0;
        }
        if (root.right == null) {
            root.MaxRight = 0;
        }
        if (root.left != null) {
            maxDistance(root.left);
        }
        if (root.right != null) {
            maxDistance(root.right);
        }

        if (root.left != null) {
//            root.left.MaxLeft
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