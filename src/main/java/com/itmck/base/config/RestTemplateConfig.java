package com.itmck.base.config;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

/**
 * Create by it_mck 2020/5/17 12:47
 *
 * @Description:
 * @Version: 1.0
 */
@Configuration
public class RestTemplateConfig {



    @Bean
    public RestTemplate getRestTemplate() {


        return new RestTemplate(new ClientHttpRequestFactory() {

            @Override
            public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {

                OkHttpClient build = new OkHttpClient();

                OkHttpClient.Builder builder = build.newBuilder();
                builder.addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {

                        Request request = chain.request().newBuilder().header("authorization", Credentials.basic("mck", "123")).build();
                        return chain.proceed(request);
                    }
                });

                OkHttp3ClientHttpRequestFactory factory = new OkHttp3ClientHttpRequestFactory(build);
                factory.setReadTimeout(1000);
                factory.setConnectTimeout(2000);
                factory.setWriteTimeout(1000);
                ClientHttpRequest request = factory.createRequest(uri, httpMethod);
                return request;
            }
        });
    }

}
