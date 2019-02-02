package com.ray.parker.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OkHttpService {

    private OkHttpClient client = new OkHttpClient();

    @Autowired
    public OkHttpService(OkHttpClient client) {
        this.client = client;
    }

    public String getResponseData(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
