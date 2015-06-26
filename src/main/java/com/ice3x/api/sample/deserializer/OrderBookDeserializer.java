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
import com.ice3x.api.sample.entity.AskVO;
import com.ice3x.api.sample.entity.BidVO;
import com.ice3x.api.sample.entity.OrderBookVO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
            final List<AskVO> asks = new ArrayList<AskVO>();//[jsonBidsArray.size()];// final AskVO[] asks = new AskVO[jsonAsksArray.size()];
            AskVO askVO ;
            final JsonArray jsonAsks = jsonAsksArray.getAsJsonArray();
            for (int i = 0; i < jsonAsks.size(); i++) {
                JsonArray tupleArray = jsonAsks.get(i).getAsJsonArray();
                askVO = new AskVO();
                JsonElement ask = tupleArray.get(0);
                askVO.setAsk(ask.getAsLong());

                JsonElement vol = tupleArray.get(1);
                askVO.setVolume(vol.getAsDouble());
                asks.add(askVO);
            }


            final JsonArray jsonBidsArray = jsonObject.get("bids").getAsJsonArray();
            final List<BidVO> bids = new ArrayList<BidVO>();//[jsonBidsArray.size()];// final AskVO[] asks = new AskVO[jsonAsksArray.size()];
            BidVO bidVO ;
            final JsonArray jsonBids = jsonBidsArray.getAsJsonArray();
            for (int i = 0; i < jsonBids.size(); i++) {
                JsonArray tupleArray = jsonBids.get(i).getAsJsonArray();
                bidVO = new BidVO();
                JsonElement ask = tupleArray.get(0);
                bidVO.setBid(ask.getAsDouble());

                JsonElement vol = tupleArray.get(1);
                bidVO.setVolume(vol.getAsDouble());
                bids.add(bidVO);
            }


            final OrderBookVO orderBookVO = new OrderBookVO();
            orderBookVO.setCurrency(currency);
            orderBookVO.setInstrument(instrument);
            orderBookVO.setTimestamp(timestamp);
            orderBookVO.setAsks(asks);
            orderBookVO.setBids(bids);
            return orderBookVO;
        }
    }

