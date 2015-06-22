package com.ice3x.api.sample.marketapi;

import com.google.gson.Gson;
import com.ice3x.api.sample.ApiBase;
import com.ice3x.api.sample.entity.OrderBookVO;
import com.ice3x.api.sample.entity.TickVO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by folashade.adeyosoye on 6/19/2015.
 */
public class OrderBookApiCall extends ApiBase {
    //REQUEST: https://api.ice3x.com/market/BTC/ZAR/orderbook
    //RESPONSE: {"currency":"ZAR","instrument":"BTC","timestamp":1434992176,"asks":[[3549.0,0.277011],[3645.0,0.98],[3739.0,1.0224016],[3740.0,0.5],[3750.0,0.5],[3795.0,0.5],[3850.0,0.01795465],[7500.0,0.006],[8700.0,0.0179]],"bids":[[3407.0,5.833],[3402.0,0.46565503],[3390.0,3.0],[3390.0,0.192],[3390.0,2.6],[3360.0,0.56308351],[3357.0,0.19913],[3350.0,3.0],[3333.0,0.66],[3310.0,0.2805592],[3306.0,0.9],[3305.0,1.0],[3302.0,1.6678716],[3302.0,0.39200835],[3301.0,1.5869],[3301.0,1.0],[3300.0,0.56282875],[3300.0,0.013589],[3300.0,5.0],[3300.0,0.12885431],[3299.0,5.0],[3280.0,0.43717125],[3230.0,0.73400822],[3206.0,0.8],[3202.4,0.8],[3200.0,1.0],[3200.0,0.07735148],[3200.0,8.0],[3150.0,0.5],[3132.0,0.03129937],[3131.0,3.1622453],[3130.0,5.6924996],[2801.0,0.2],[2800.0,1.4693779],[2800.0,0.00128625],[600.0,0.0698],[442.84,0.00718941],[190.0,0.060006],[183.0,0.05658531],[183.0,0.05658531],[130.0,0.01],[130.0,0.01],[10.0,10.0],[1.0,50.0],[0.99,100.0]]}


    private static String PATH = "/market/BTC/ZAR/orderbook";
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
                OrderBookVO orderBookVO = gson.fromJson(response, OrderBookVO.class); // convert back
                String str = orderBookVO.toString(response);
                System.out.println(str);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
