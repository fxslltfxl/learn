package utils;

import okhttp3.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * http工具类
 */
public class OkHttp3Util {


    private static volatile OkHttpClient okHttpClient = null;

    private OkHttp3Util() {
    }

    // 测试merge与rebase的区别（test'分支）
    public static OkHttpClient getInstance() {
        if (okHttpClient == null) {
            synchronized (OkHttp3Util.class) {
                if (okHttpClient == null) {
                    //指定缓存大小
                    int cacheSize = 10 * 1024 * 1024;
                    //构建器
                    okHttpClient = new OkHttpClient.Builder()
                            //连接超时
                            .connectTimeout(5, TimeUnit.SECONDS)
                            //写入超时
                            .writeTimeout(5, TimeUnit.SECONDS)
                            //读取超时
                            .readTimeout(5, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return okHttpClient;
    }

    /**
     * 同步get请求（需要在子线程中执行）
     *
     * @param url url
     * @return response
     */
    public static Response doGet(String url) {
        Response response = null;
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getInstance();
        //创建Request
        Request request = new Request.Builder().url(url).build();
        //得到Call对象
        Call call = okHttpClient.newCall(request);
        //执行同步请求
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * 异步get请求
     *
     * @param url      url
     * @param callback 回调Callback
     */
    public static void doGet(String url, Callback callback) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getInstance();
        //创建Request
        Request request = new Request.Builder().url(url).build();
        //得到Call对象
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(callback);
    }

    /**
     * head 请求 （）
     *
     * @param url      url
     * @param callback 异步回调
     */
    public static void doHead(String url, Callback callback) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getInstance();
        //创建Request
        Request request = new Request.Builder().url(url).head().build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    /**
     * post请求
     *
     * @param url      url
     * @param params   Map<String, String> params post请求的时候给服务器传的数据
     * @param callback 异步回调
     */
    public static void doPost(String url, Map<String, String> params, Callback callback) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getInstance();
        //3.x版本post请求换成FormBody 封装键值对参数
        FormBody.Builder builder = new FormBody.Builder();
        //遍历集合
        for (String key : params.keySet()) {
            builder.add(key, params.get(key));
        }
        //创建Request
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

    /**
     * post请求上传文件....包括图片....流的形式传任意文件...
     *
     * @param url      url
     * @param file     file表示上传的文件
     * @param fileName fileName....文件的名字,,例如aaa.jpg
     * @param params   params ....传递除了file文件 其他的参数放到map集合
     */
    public static void uploadFile(String url, File file, String fileName, Map<String, String> params) {
        //创建OkHttpClient请求对象
        OkHttpClient okHttpClient = getInstance();
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);

        //参数
        if (params != null) {
            for (String key : params.keySet()) {
                builder.addFormDataPart(key, params.get(key));
            }
        }
        //文件...参数name指的是请求路径中所接受的参数...如果路径接收参数键值是file,此处应该改变
        builder.addFormDataPart("file", fileName, RequestBody.create(MediaType.parse("application/octet-stream"),
                file));
        //构建
        MultipartBody multipartBody = builder.build();
        //创建Request
        Request request = new Request.Builder()
                .url(url)
                .post(multipartBody)
                .build();
        //得到Call
        Call call = okHttpClient.newCall(request);
        //执行请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //上传成功回调 目前不需要处理
                if (response.isSuccessful()) {
                    String s = response.body().string();
                }
            }
        });
    }

    /**
     * Post请求发送JSON数据....{"name":"zhangsan","pwd":"123456"}
     *
     * @param url        请求Url
     * @param jsonParams 请求的JSON
     * @param callback   请求回调
     */
    public static void doPostJson(String url, String jsonParams, Callback callback) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jsonParams);
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Call call = getInstance().newCall(request);
        call.enqueue(callback);
    }

    public static void download() {

    }

    /**
     * 下载文件 以流的形式写入的指定文件
     * @param url     参数er：请求Url
     * @param saveDir 保存文件的文件夹....download
     */
    public static void downloadFile(final String url, final String saveDir) {
        Request request = new Request.Builder().url(url).build();
        Call call = getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.err.println(e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len;
                FileOutputStream fos = null;
                try {
                    //以字节流的形式拿回响应实体内容
                    is = response.body().byteStream();
                    //保存路径
                    final String fileDir = fileDir(saveDir);
                    //文件
                    File file = new File(fileDir, getNameFromUrl(url));


                    fos = new FileOutputStream(file);
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (is != null) {
                        is.close();
                    }
                    if (fos != null) {
                        fos.close();
                    }
                }
            }
        });
    }

    private static String fileDir(String saveDir) {
        return null;
    }

    /**
     * 从下载连接中解析出文件名
     *
     * @param url 路由地址
     * @return 从下载连接中解析出文件名
     */
    private static String getNameFromUrl(String url) {
        return url.substring(url.lastIndexOf("/") + 1);
    }
}
