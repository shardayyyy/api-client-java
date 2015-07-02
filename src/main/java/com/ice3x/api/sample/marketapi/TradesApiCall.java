package com.ice3x.api.sample.marketapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ice3x.api.sample.ApiBase;
import com.ice3x.api.sample.deserializer.TradeDeserializer;
import com.ice3x.api.sample.entity.AllTrades;
import com.ice3x.api.sample.entity.OrderBookVO;
import com.ice3x.api.sample.entity.TradeVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by folashade.adeyosoye on 6/19/2015.
 */
public class TradesApiCall extends ApiBase {
    //REQUEST: https://api.ice3x.com/market/BTC/ZAR/trades
    //RESPONSE: [{"tid":4432702312,"amount":10000000,"price":14000000000,"date":1378878093},{"tid":59861212129,"amount":1000000,"price":12500000000,"date":1377840783}]



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
                // Configure Gson
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.registerTypeAdapter(AllTrades.class, new TradeDeserializer());
                Gson gson = gsonBuilder.create();
                AllTrades trades = gson.fromJson(response, AllTrades.class); // Deserialize

                String str = trades.toString();
                System.out.println(str);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
