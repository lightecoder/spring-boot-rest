package com.ray.parker.utils;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mortbay.jetty.webapp.WebAppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HttpServiceTest {

    @Autowired
    private HttpService httpService;
    @MockBean
    private OkHttpClient clientMock;
    private OkHttpClient client;
    private String url;
    private Request request;

    @Before
    public void setUp() {
        client = new OkHttpClient();
        url = "https://lb-api-sandbox.prozorro.gov.ua/api/2.4/contracts/4805f381d48948b1b34d6ea2daa029a3/documents";
        request = new Request.Builder().url(url).build();
    }

    @Test
    public void whenGetRequest_thenCorrect() throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        assertThat(response.code(), equalTo(200));
    }

    @Test
    public void getResponseData() throws IOException {
        MockWebServer mockWebServer = new MockWebServer();
        mockWebServer.enqueue(new MockResponse().setBody(url));
        mockWebServer.start();
        String bodyOfRequest = httpService.getResponseData( url);
        assertEquals(url, bodyOfRequest);
    }
}