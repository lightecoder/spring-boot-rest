package com.ray.parker.utils;

import okhttp3.*;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class mockWebServerTest {

    private MockWebServer server;
    private HttpService httpService;

    @Before
    public void setUp() {
        server = new MockWebServer();
        httpService = new HttpService(new OkHttpClient());
    }

    @Test
    public void getResponseData() throws IOException, InterruptedException {
        MockResponse mockResponse = new MockResponse();
        server.enqueue(mockResponse.setBody("hello"));
        server.start();
        HttpUrl url = server.url("/documents");
        //String bodyOfRequest = sendGetRequest(new OkHttpClient(), url); additional method for internal testing
        String bodyOfRequest = httpService.getResponseData(url.toString());
        // confirm that your app made the HTTP requests you were expecting.
        RecordedRequest request = server.takeRequest();
        assertEquals("hello", bodyOfRequest);
        assertEquals("HTTP/1.1 200 OK", mockResponse.getStatus());
        assertEquals("/documents", request.getPath());
        server.shutdown();
    }

    private String sendGetRequest(OkHttpClient okHttpClient, HttpUrl url) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), "hello");
        okhttp3.Request request = new okhttp3.Request.Builder()
                .post(body)
                .url(url)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        return response.body().string();
    }
}
