package com.zaki.httpclientTest;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;

import java.io.IOException;

public class HttpClientTest {
    @Test
    public void test1() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://127.0.0.1/");
        CloseableHttpResponse execute = client.execute(httpGet);
        HttpEntity entity = execute.getEntity();
        System.out.println(entity.toString());
    }
}
