package micsoftinterview;

import java.util.Random;

/**
 * 编程之美 1.3 一摞烙饼的排序
 *
 * @Author fxs
 * @Description 编程之美 1.3 一摞烙饼的排序
 * @Date 2019/11/18
 **/

public class TheSortStackOfFritter {

    static int[] data;

    public static void main(String[] args) {
        data = new int[10];

        for (int i = 0; i < data.length; i++) {
            int random = new Random().nextInt(10);
            data[i] = random;
            System.out.println(random);
        }
        System.out.println("-----------------");
        sort();

        for (int datum : data) {
            System.out.println(datum);
        }
    }


    static void sort() {
        int n = data.length;
        int j = n - 1;
        int maxData = 0, maxIndex = 0;

        while (j > 0) {
            //每次要把最大值置为"-1"，否则为上一次循环的数值
            maxData = -1;
            for (int i = 0; i <= j; i++) {
                if (data[i] > maxData) {
                    maxData = data[i];
                    maxIndex = i;
                }
            }
            revert(0, maxIndex);
            revert(0, j);
            j--;
        }
    }


    private static void revert(int start, int end) {
        for (; start < end; start++, end--) {
            /**
             * this mean's
             * data[start] = data[start] ^ data[end];
             * data[end] = data[start] ^ data[end];
             * data[start] = data[start] ^ data[end];
             */
            data[start] ^= data[end];
            data[end] ^= data[start];
            data[start] ^= data[end];
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