package com.ray.parker.utils;

import okhttp3.Request;
import okhttp3.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OkHttpServiceTest {

    private  String url;

    @Before
    public void setUp() {
        url = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/4805f381d48948b1b34d6ea2daa029a3/documents";
    }

    @Test
    public void getResponseData() {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}