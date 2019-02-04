package com.ray.parker.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class HttpClientConfiguration {
    @Bean
    public OkHttpClient httpClient() {
        return new OkHttpClient();
    }

//    @Bean
//    public Request request() {
//        return new Request.Builder().url("").build();
//    }
//
//    @Bean
//    public Response response() throws IOException {
//        return new OkHttpClient().newCall(new Request.Builder().url("").build()).execute();
//    }

}
