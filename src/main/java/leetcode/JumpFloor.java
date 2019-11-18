package leetcode;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/11/14
 **/
public class JumpFloor {
    public static void main(String[] args) {
        System.out.println(jumpFloorRecursion(3));
    }

    public static int jumpFloorRecursion(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        return jumpFloorRecursion(target - 1) + jumpFloorRecursion(target - 2);
    }

    public static int jumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;

        int a = 1, b = 2;
        int temp;
        for (int i = 3; i <= target; i++) {
            temp = a;

            a = b;

            b += temp;
        }
        return b;
    }

    public static int jumpFloorByAnyStepForOnce(int target) {
        return (int) Math.pow(2,target-1);
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