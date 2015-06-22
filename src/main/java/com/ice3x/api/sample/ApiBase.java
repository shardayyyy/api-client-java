package com.ice3x.api.sample;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by shardayyy on 6/22/15.
 */
public class ApiBase {

    public static final String API_KEY = "NOT_REAL_API_KEY==";//"Please sign up on the website to get an api key and replace it here";
    public static final String PRIVATE_KEY = "NOT_REAL_PRIVATE_KEY==";//"Replace your private key here";

    public static String BASEURL = "https://api.ice3x.com";
    public static final String APIKEY_HEADER = "apikey";
    public static final String TIMESTAMP_HEADER = "timestamp";
    public static final String SIGNATURE_HEADER = "signature";
    public static final String ENCODING = "UTF-8";
    public static final String ALGORITHM = "HmacSHA512";


    //*******************************************************************************************************

    protected static String executeRestfulCall(String urlString) {

        String output = "";
        String response = "";
        try {

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                response += output;
                //System.out.println(output);
            }

            conn.disconnect();


        } catch (Exception e) {
            System.out.println("Error in executeRestfulCall " + e.getMessage());
        }
        return response;
    }

    //*******************************************************************************************************

    public static String executeHttpPost(String postData, String url,
                                         String apiKey, String privateKey, String signature, String timestamp) throws Exception {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = null;

        try {
            HttpPost httpPost = new HttpPost(url);

            // post any data that needs to go with http request.
            if (postData != null) {
                httpPost.setEntity(new StringEntity(postData, ENCODING));
            }
            // Set http headers
            httpPost.addHeader("Accept", "*/*");
            httpPost.addHeader("Accept-Charset", ENCODING);
            httpPost.addHeader("Content-Type", "application/json");

            // Add signature, timestamp and apiKey to the http header
            httpPost.addHeader(SIGNATURE_HEADER, signature);
            httpPost.addHeader(APIKEY_HEADER, apiKey);
            httpPost.addHeader(TIMESTAMP_HEADER, timestamp);

            // execute http request
            httpResponse = httpClient.execute(httpPost);

            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException(httpResponse.getStatusLine().getReasonPhrase());
            }
            // return JSON results as String
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = responseHandler.handleResponse(httpResponse);
            return responseBody;

        } catch (Exception e) {
            throw new RuntimeException("unable to execute json call:" + e);
        } finally {
            // close http connection
            if (httpResponse != null) {
                HttpEntity entity = httpResponse.getEntity();
                if (entity != null) {
                    //entity.consumeContent();
                    EntityUtils.consume(entity);
                }
            }
            if (httpClient != null) {
                httpClient.getConnectionManager().shutdown();
            }
        }
    }

    protected static String buildStringToSign(String uri, String queryString,
                                              String postData, String timestamp) {
        // queryString must be sorted key=value& pairs
        String stringToSign = uri + "\n";
        if (queryString != null) {
            stringToSign += queryString + "\n";
        }
        stringToSign += timestamp + "\n";
        stringToSign += postData;
        return stringToSign;
    }

    protected static String signRequest(String secret, String data) {
        String signature = "";
        try {
            Mac mac = Mac.getInstance(ALGORITHM);
            SecretKeySpec secret_spec = new SecretKeySpec(Base64.decodeBase64(secret), ALGORITHM);
            mac.init(secret_spec);
            signature = Base64.encodeBase64String(mac.doFinal(data.getBytes()));
        } catch (InvalidKeyException e) {
            System.out.println(e);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return signature;
    }
}
