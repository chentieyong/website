package com.shenzhou.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public abstract class HttpUtil {

    private static final String DEFAULT_CHARSET = "UTF-8";

    private static class DefaultTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
    }

    public static String doPost(String url) throws IOException {

        return doPost(url, null);
    }

    public static String doGet(String url) throws IOException {

        return doGet(url, null);
    }

    public static String doPost(String url, Map<String, Object> params) throws IOException {
        String result = null;
        InputStream instream = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);
            HttpParams param = new BasicHttpParams();
            if (null != params && !params.isEmpty()) {
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    param.setParameter(entry.getKey(), entry.getValue());
                }
            }
            httpPost.setParams(param);
            HttpResponse httpResponse = httpclient.execute(httpPost);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                instream = entity.getContent();
                result = getStreamAsString(instream, DEFAULT_CHARSET);
            }
        } finally {
            if (null != instream) {
                instream.close();
            }
        }

        return result;
    }

    public static String doGet(String url, Map<String, String> params) throws IOException {
        String result = null;
        InputStream instream = null;
        try {
            HttpClient httpclient = new DefaultHttpClient();
            StringBuilder urlGet = new StringBuilder(url);
            String urlParam = buildQuery(params, DEFAULT_CHARSET);
            if (StringUtils.isNotEmpty(urlParam)) {
                if (url.contains("?") && url.contains("=")) {
                    urlGet.append("&");
                } else {
                    urlGet.append("?");
                }
                urlGet.append(urlParam);
            }
            HttpGet httpget = new HttpGet(urlGet.toString());
            HttpResponse response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                instream = entity.getContent();
                result = getStreamAsString(instream, DEFAULT_CHARSET);
                System.out.println(new Date().toLocaleString() + " ---> " + httpget.getURI() + " ---> " + result);
            }
        } finally {
            if (null != instream)
                instream.close();
        }
        return result;
    }


    public static String buildQuery(Map<String, String> params, String charset) throws IOException {
        if (params == null || params.isEmpty()) {
            return null;
        }
        StringBuilder query = new StringBuilder();
        Set<Map.Entry<String, String>> entries = params.entrySet();
        boolean hasParam = false;

        for (Map.Entry<String, String> entry : entries) {
            String name = entry.getKey();
            String value = entry.getValue();
            // 忽略参数名或参数值为空的参数
            if (StringUtil.areNotEmpty(name, value)) {
                if (hasParam) {
                    query.append("&");
                } else {
                    hasParam = true;
                }

                query.append(name).append("=").append(URLEncoder.encode(value, charset));
            }
        }

        return query.toString();
    }


    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        String result = null;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(stream, charset));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            result = buffer.toString();

        } finally {
            if (null != stream) {
                stream.close();
            }
            if (null != in) {
                in.close();
            }
        }
        return result;
    }

}
