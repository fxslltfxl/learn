package leetcode.queue.medium;

import java.util.Arrays;

/**
 * @Author fxs
 * @Description Given a char array representing tasks CPU need to do. It contains capital letters A to Z where
 * different letters represent different tasks. Tasks could be done without original order. Each task could be done
 * in one interval. For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n
 * intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 思路：
 * <p>
 * 排序
 * n=1
 * A ：3
 * B ：4
 * C ：5
 * <p>
 * 每组N+1 个数  每次从最多的开始拿 没有的话就加idle 有的话更新每个元素的个数 ，然后每完成一组 重新排序；
 * @Date 2019/11/29
 **/
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length == 1) {
            return 1;
        }
        if (n == 0) {
            return tasks.length;
        }
        int[] ints = new int[26];
        for (char c : tasks) {
            ints[c - 'A']++;
        }
        Arrays.sort(ints);
        int time = 0;
        while (ints[25] > 0) {
            // 每组 N+1 个数
            int i = 0;
            while (i < n + 1) {
                if (ints[25] == 0) break;
                if (i < 26 && ints[25 - i] > 0) {
                    ints[25 - i]--;
                }
                i++;
                time++;
            }
            Arrays.sort(ints);
        }
        return time;
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