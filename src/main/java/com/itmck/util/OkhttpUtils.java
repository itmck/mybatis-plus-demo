package com.itmck.util;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Create by it_mck 2020/1/9 11:10
 *
 * @Description:
 * @Version: 1.0
 */
public class OkhttpUtils {

    private static final long DEFAULT_CONNECT_TIMEOUT = 30;
    private static final long DEFAULT_READ_TIMEOUT = 60;
    private static final String DEFAULT_CODE = "UTF-8";
    private static OkHttpClient client;

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    static {

        client = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS).build();
    }


    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


}
