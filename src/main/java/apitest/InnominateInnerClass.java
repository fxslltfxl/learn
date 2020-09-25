package apitest;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2020/2/28
 **/
public class InnominateInnerClass {

    void usename(InnominateInnerClass innominateInnerClass) {
        System.out.println("1");
    }

    String name = "test";

    public static <T> List<T> test(List<T> args) {
        List<Integer> a = (List<Integer>) args;
        return args;
    }

    List<Map<String,String>> testSecond(){
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
//        System.out.println();
//
//        List<Integer> ints = new ArrayList<>();
//
//        ints.add(11);
//        test(ints);

        ParameterizedType test = (ParameterizedType) InnominateInnerClass.class.getDeclaredMethod("testSecond").getGenericReturnType();
        for (Type ty : test.getActualTypeArguments()) {
            System.out.println(ty);
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