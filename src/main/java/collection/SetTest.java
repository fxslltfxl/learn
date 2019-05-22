package collection;

import java.util.LinkedHashMap;
import java.util.Map;

public class SetTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");


        //使用
        map.get("1");
        Map.Entry<String, String> last =null;

        for (Map.Entry<String, String> entry : map.entrySet()) {
            last = entry;
        }

        System.out.println(last.getKey()+last.getValue());
    }

    protected void protectedMethod(){

    }

    protected void friendlyMethod(){

    }

}
