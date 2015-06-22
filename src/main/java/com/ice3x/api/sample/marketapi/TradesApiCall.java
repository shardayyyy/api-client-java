package com.ice3x.api.sample.marketapi;

import com.google.gson.Gson;
import com.ice3x.api.sample.ApiBase;
import com.ice3x.api.sample.entity.OrderBookVO;
import com.ice3x.api.sample.entity.TradeVO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by folashade.adeyosoye on 6/19/2015.
 */
public class TradesApiCall extends ApiBase {


    private static String PATH = "/market/BTC/ZAR/trades";
    private HttpServletRequest request;


    public static void main(String[] args) throws Exception {
        String response = "";
        try {
            //full url path
            String urlString = BASEURL + PATH;
            System.out.println("url=" + urlString);

            response = executeRestfulCall(urlString);
            System.out.println("Results=" + response);

            if (response != null && response.length() > 0) {
                Gson gson = new Gson();
                TradeVO tradeVO = gson.fromJson(response, TradeVO.class); // convert back
                String str = tradeVO.toString(response);
                System.out.println(str);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
