package pattern.strategy;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/12/11
 **/
public class WebViewPlugin implements IStrategy {
    @Override
    public void test() {

    }

    @Override
    public void onPageFinished() {

    }

    @Override
    public void onPageStart() {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode temp;

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            root.left = root.right;
            root.right = null;
        } else if (root.right == null) {
            root.right = root.left;
            root.left = null;
        } else {
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
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