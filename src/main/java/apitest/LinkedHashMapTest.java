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
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i),String.valueOf(i));
        }
        map.put(String.valueOf(1),String.valueOf(5));

        Set<Map.Entry<String, String>> entries = map.entrySet();

        for (Map.Entry<String, String> entry: entries) {
            System.out.println("Map.Entry<String, String>" + entry.getKey()+"   "+entry.getValue());
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