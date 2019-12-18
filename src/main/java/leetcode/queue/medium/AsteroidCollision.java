package leetcode.queue.medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/12/2
 **/
public class AsteroidCollision {

    Queue<Integer> queue = new LinkedList<>();

    int resSize;

    int tempSize;

    public static void main(String[] args) {

        int[] ints = {-2, -1, 1, 2};

        int[] ints1 = asteroidCollision(ints);

        System.out.println("");
    }

    public static int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> s = new LinkedList<>();

        for (int i : asteroids) {
            // if not empty, check sign, if diff, pop elem that has smaller
            // if empty add
            boolean remove = false;
            while (!s.isEmpty() && s.peek() > 0 && i < 0) {
                if (s.peek() + i < 0) s.pop();
                else if (s.peek() + i == 0) {
                    s.pop();
                    remove = true;
                    break;
                } else {
                    remove = true;
                    break;
                }
            }

            if (!remove) s.push(i);
        }

        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) res[i] = s.pop();
        return res;
    }

//    public int[] asteroidCollision(int[] asteroids) {
//
//        for (int i = 0; i < asteroids.length; i++) {
//            queue.offer(asteroids[i]);
//        }
//        Queue<Integer> integers = asteroidCollision(queue);
//        if (integers == null || integers.size() == 0) {
//            return new int[0];
//        } else {
//            int[] ints = new int[integers.size()];
//            for (int i = 0; i < integers.size(); i++) {
//                ints[i] = integers.remove();
//            }
//            return ints;
//        }
//    }

    public Queue<Integer> asteroidCollision(Queue<Integer> asteroids) {

        int size = asteroids.size();

        if (size == 0) {
            return null;
        }

        if (size % 2 == 0) {

        } else {

        }

        return null;
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