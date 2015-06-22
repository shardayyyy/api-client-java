package com.ice3x.api.sample.tradingapi;

import com.google.gson.Gson;
import com.ice3x.api.sample.ApiBase;
import com.ice3x.api.sample.common.Currency;
import com.ice3x.api.sample.entity.PostData;

public class OrderHistory extends ApiBase {

    private static String ORDER_CREATE_PATH = "/order/create";


    // Write sample code for all api calls
    //ice3x.create_order('ZAR', 'BTC', 13000000000, 1000000, 'Bid', 'Limit', '1', handleResponse);
    //var orderIds=[243463];
    //ice3x.cancel_order(orderIds, handleResponse);

    //var orderIds=[17463];
    //ice3x.order_detail(orderIds, handleResponse);

    //ice3x.open_orders('ZAR', 'BTC', 10, 78343, handleResponse);

    //ice3x.order_history('ZAR', 'BTC', 10, 7834, handleResponse);

    //ice3x.trade_history('ZAR', 'BTC', 10, 119834, handleResponse);

    //ice3x.account_balance(handleResponse);

    public static void main(String[] args) throws Exception {
        String response = "";
        try {

            // Display Balance


            // input parameters for creating a new account. data is posted via https
            //String postData = "{\"currency\":\"ZAR\",\"instrument\":\"BTC\",\"price\":13000000000,\"volume\":10000000,\"orderSide\":\"Bid\",\"ordertype\":\"Limit\",\"clientRequestId\":\"1\"}";
            PostData data = new PostData();
            data.setCurrency(Currency.DOLLAR);
            data.setInstrument("BTC");
            data.setPrice(13000000000L);
            data.setVolume(10000000);
            data.setOrderSide("Bid");
            data.setOrdertype("Limit");
            data.setClientRequestId("1");
            Gson gson = new Gson();
            String postData = gson.toJson(data);
            //System.out.println("json    =" + postData);
            System.out.println("postData=" + postData);
            //PostData obj2 = gson.fromJson(json, PostData.class); // convert back

            //get the current timestamp. It's best to use ntp or similar services in order to sync your server time
            String timestamp = Long.toString(System.currentTimeMillis());

            // create the string that needs to be signed
            String stringToSign = buildStringToSign(ORDER_CREATE_PATH, null, postData, timestamp);
            System.out.println("stringToSign=" + stringToSign);

            // build signature to be included in the http header
            String signature = signRequest(PRIVATE_KEY, stringToSign);
            System.out.println("Signature=" + signature);

            //full url path
            String url = BASEURL + ORDER_CREATE_PATH;
            System.out.println("url=" + url);

            response = executeHttpPost(postData, url, API_KEY, PRIVATE_KEY, signature, timestamp);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("response=" + response);
    }

}
