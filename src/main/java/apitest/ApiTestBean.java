package apitest;

import okhttp3.OkHttpClient;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ApiTestBean {

    private String FieldFirst;

    public ApiTestBean(String fieldFirst) {
        FieldFirst = fieldFirst;
    }

    public String getFieldFirst() {
        return FieldFirst;
    }

    public void setFieldFirst(String fieldFirst) {
        FieldFirst = fieldFirst;
    }


    public static void main(String[] args) {
        List<ApiTestBean> test = new ArrayList<>();

        test.add(new ApiTestBean("1"));
        test.add(new ApiTestBean("1"));
        test.add(new ApiTestBean("1"));
        test.add(new ApiTestBean("1"));
        
        ApiTestBean apiTestBean = new ApiTestBean("1");
        boolean remove = test.remove(apiTestBean);
        System.out.println(remove);

    }
}
