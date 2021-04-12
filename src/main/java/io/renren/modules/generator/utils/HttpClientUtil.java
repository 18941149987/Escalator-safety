package io.renren.modules.generator.utils;


import cn.hutool.json.JSONObject;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class HttpClientUtil {

    public static Map get(String url) {
        HttpGet get = new HttpGet(url);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result;
//        JSONObject jsonObject = new JSONObject();
        Map mapType = new HashMap();
        try {
            get.addHeader("api-key", "Ha=Q8Kwrz7d09iRh=V75sY4DqOQ=");
            HttpResponse response = httpClient.execute(get);
            HttpEntity responseEntity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                // ----------------------------
                result = EntityUtils.toString(responseEntity, "UTF-8");
//                jsonObject = new JSONObject(result);
                mapType = JSON.parseObject(result,Map.class);

            } else {
                EntityUtils.consume(responseEntity);
                String failReason = response.getStatusLine().getReasonPhrase();
                throw new RuntimeException("Http访问异常[" + statusCode + "]:" + failReason);
            }
        } catch (Exception e) {
            log.info("http请求访问失败！",e);
            throw new RuntimeException(e);
        } finally {
            get.abort();
        }
        return mapType;
    }

}