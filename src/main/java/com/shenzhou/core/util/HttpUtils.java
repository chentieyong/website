package com.shenzhou.core.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Map.Entry;


public abstract class HttpUtils {
    private static final Logger LOG = LoggerFactory.getLogger(HttpUtils.class);
    private static final String POST_METHOD = "POST";
    private static final String ENCODING = "UTF-8";

    public static boolean postOnly(String serverUrl, Map<String, String> data, int timeout) {
        InputStream is = null;
        try {
            is = post(serverUrl, data, timeout);
            return true;
        } catch (Throwable ignore) {
            if (null != is)
                try {
                    is.close();
                } catch (IOException e) {
                }
        } finally {
            if (null != is)
                try {
                    is.close();
                } catch (IOException e) {
                }
        }
        return false;
    }

    public static InputStream post(String serverUrl, Map<String, String> data, int timeout) throws IOException {
        OutputStreamWriter writer = null;
        try {
            URL url = new URL(serverUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            if ("https".equals(url.getProtocol())) {
                LOG.debug("init ssl context for {}", serverUrl);

                SSLContext sslContext = SSLContext.getInstance("SSL");

                sslContext.init(new KeyManager[0], new TrustManager[]{new TrustAnyTrustManager(null)}, new SecureRandom());
                SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

                ((HttpsURLConnection) conn).setSSLSocketFactory(sslSocketFactory);
            }

            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setConnectTimeout(timeout);
            writer = new OutputStreamWriter(conn.getOutputStream());
            boolean first;
            if (null != data) {
                first = true;
                for (Entry entry : data.entrySet()) {
                    if (!first) {
                        writer.write(38);
                    }
                    first = false;
                    writer.write(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                    writer.write(61);
                    writer.write(URLEncoder.encode((String) entry.getValue(), "UTF-8"));
                }
            }
            writer.flush();

            return conn.getInputStream();
        } catch (NoSuchAlgorithmException e) {
            LOG.warn("", e);
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            LOG.warn("", e);
            throw new RuntimeException(e);
        } finally {
            if (null != writer)
                try {
                    writer.close();
                } catch (IOException ignore) {
                }
        }
    }

    private static class TrustAnyTrustManager implements X509TrustManager {
        public TrustAnyTrustManager(Object o) {
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}
