package apitest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/12/30
 **/
public class ConcurrentModificationExceptionTest {
    public static void main(String[] args) {
//      CopyOnWriteArrayList  不会发生ConcurrentModificationException
//        List<String> userNames = new CopyOnWriteArrayList<>() {{
//            add("Hollis");
//            add("hollis");
//            add("HollisChuang");
//            add("H");
//        }};
//      ArrayList  发生ConcurrentModificationException
        List<String> userNames = new ArrayList<>() {{
            add("Hollis");
            add("hollis");
            add("HollisChuang");
            add("H");
        }};

        Iterator it = userNames.iterator();
//      throw ConcurrentModificationException
//        for (String userName : userNames) {
//            if (userName.equals("Hollis")) {
//                userNames.remove(userName);
//            }
//        }
//      normal  for CopyOnWriteArrayList and ArrayList
        while (it.hasNext()) {
            if (it.next().equals("Hollis")) {
                it.remove();
            }
        }
        System.out.println(userNames);
        while (it.hasNext()) {
            System.out.println(it.next());
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