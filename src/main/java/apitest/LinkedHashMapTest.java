package apitest;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/11/27
 **/
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(0, 0.75f, true);

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }
        map.put(String.valueOf(1), String.valueOf(5));

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println("Map.Entry<String, String>" + entry.getKey() + "   " + entry.getValue());
        }

        int i = tableSizeFor(9);

        System.out.println(i);

        int i1 = -1 >>> 1;
        System.out.println(Integer.toHexString(i1));
    }

    static final int tableSizeFor(int cap) {
        int n = -1 >>> numberOfLeadingZeros(cap - 1);
        System.out.println("n: " + n);
        return (n < 0) ? 1 : n + 1;
    }

    public static int numberOfLeadingZeros(int i) {
        // HD, Count leading 0's
        if (i <= 0)
            return i == 0 ? 32 : 0;
        int n = 31;
        if (i >= 1 << 16) { n -= 16; i >>>= 16; }
        if (i >= 1 << 8) { n -= 8; i >>>= 8; }
        if (i >= 1 << 4) { n -= 4; i >>>= 4; }
        if (i >= 1 << 2) { n -= 2; i >>>= 2; }
        return n - (i >>> 1);
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