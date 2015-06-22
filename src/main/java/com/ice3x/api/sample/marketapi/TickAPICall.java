package com.ice3x.api.sample.marketapi;

import com.google.gson.Gson;
import com.ice3x.api.sample.ApiBase;
import com.ice3x.api.sample.entity.TickVO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by folashade.adeyosoye on 6/19/2015.
 */
public class TickApiCall extends ApiBase {


    private static String TICK_PATH = "/market/BTC/ZAR/tick";
    private HttpServletRequest request;


    public static void main(String[] args) throws Exception {
        String response = "";
        try {
            //full url path
            String urlString = BASEURL + TICK_PATH;
            System.out.println("url=" + urlString);

            response = executeRestfulCall(urlString);
            System.out.println("Results=" + response);

            if (response != null && response.length() > 0) {
                Gson gson = new Gson();
                TickVO tickVO = gson.fromJson(response, TickVO.class); // convert back
                String str = tickVO.toString(response);
                System.out.println(str);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
