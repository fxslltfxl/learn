package leetcode;

import java.util.Scanner;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/11/17
 **/
public class JumpArray {


    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        return jump(nums, nums.length, 0);
    }

    public int jump(int[] nums, int n, int step) {
        if (step >= n - 1) {
            return 1;
        }
        for (int i = nums[step]; i > 0; i--) {
            if (jump(nums, n, step + i) == 1) //递归  数组的元素作为下标传过去继续跳跃    //当1.
                // 返回1的时候，这个if就会正确，开始把递归嵌套调用的jump一步一步拨开，最后返回1。
                //当某次调用时候，x+i对应的元素是0的时候，这时候i=arr[x]=0，
                //for循环体不执行 走到3的位置 返回0 ，那么返回到上一层的if
                //不成立，执行循环体，即i--，看上一位是否可以jump到n
                //如果不可能，就像第二个例子，最终i--到i=0的时候
                //return 0 。。。拨开递归。。最后一层jump拨开
                //最终返回0；
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }


}
//                            _ooOoo_  
//                           o8888888o  
//                           88" . "88  
//                           (| -_- |)  
//                            O\ = /O  
//                        ____/`---'\____  
//                      .   ' \\| |// `.  
//                       / \\||| : |||// \  
//                     / _||||| -:- |||||- \  
//                       | | \\\ - /// | |  
//                     | \_| ''\---/'' | |  
//                      \ .-\__ `-` ___/-. /  
//                   ___`. .' /--.--\ `. . __  
//                ."" '< `.___\_<|>_/___.' >'"".  
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |  
//                 \ \ `-. \_ __\ /__ _/ .-` / /  
//         ======`-.____`-.___\_____/___.-`____.-'======  
//                            `=---='  
//  
//         .............................................  
//                  佛祖镇楼                  BUG辟易  
//          佛曰:  
//                  写字楼里写字间，写字间里程序员；  
//                  程序人员写程序，又拿程序换酒钱。  
//                  酒醒只在网上坐，酒醉还来网下眠；  
//                  酒醉酒醒日复日，网上网下年复年。  
//                  但愿老死电脑间，不愿鞠躬老板前；  
//                  奔驰宝马贵者趣，公交自行程序员。  
//                  别人笑我忒疯癫，我笑自己命太贱；  
//                  不见满街漂亮妹，哪个归得程序员？ 