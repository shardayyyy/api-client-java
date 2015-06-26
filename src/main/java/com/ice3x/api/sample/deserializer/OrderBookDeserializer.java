package com.ice3x.api.sample.deserializer;

/**
 * Created by folashade.adeyosoye on 6/26/2015.
 */

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.ice3x.api.sample.entity.OrderBookVO;

import java.lang.reflect.Type;

//http://www.javacreed.com/gson-deserialiser-example/
public class OrderBookDeserializer implements JsonDeserializer<OrderBookVO> {

        @Override
        public OrderBookVO deserialize(final JsonElement json,  final Type typeOfT, final JsonDeserializationContext context)
                throws JsonParseException {
            final JsonObject jsonObject = json.getAsJsonObject();


    //       private Double[] asks;
    //        private Double[] bids;

            //final JsonElement jsonTitle = jsonObject.get("title");
            //final String title = jsonTitle.getAsString();

            final String currency = jsonObject.get("currency").getAsString();
            final String instrument = jsonObject.get("instrument").getAsString();
            final Long timestamp = jsonObject.get("timestamp").getAsLong();

            final JsonArray jsonAsksArray = jsonObject.get("asks").getAsJsonArray();
            final Double[] asks = new Double[jsonAsksArray.size()];
            for (int i = 0; i < asks.length; i++) {
                final JsonElement jsonAsks = jsonAsksArray.get(i);
                asks[i] = jsonAsks.getAsDouble();
            }

            final JsonArray jsonBidsArray = jsonObject.get("bids").getAsJsonArray();
            final Double[] bids = new Double[jsonBidsArray.size()];
//            for (int i = 0; i < bids.length; i++) {
//                final JsonElement jsonBids = jsonBidsArray.get(i);
//                bids[i] = jsonBids.getAsDouble();
//            }

            final OrderBookVO orderBookVO = new OrderBookVO();
            orderBookVO.setCurrency(currency);
            orderBookVO.setInstrument(instrument);
            orderBookVO.setTimestamp(timestamp);
            orderBookVO.setAsks(asks);
            orderBookVO.setBids(bids);
            return orderBookVO;
        }
    }

