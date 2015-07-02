package com.ice3x.api.sample.deserializer;

/**
 * Created by folashade.adeyosoye on 6/26/2015.
 */

import com.google.gson.*;
import com.ice3x.api.sample.entity.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//http://www.javacreed.com/gson-deserialiser-example/
public class TradeDeserializer implements JsonDeserializer<AllTrades> {
    //[{"tid":4432702312,"amount":10000000,"price":14000000000,"date":1378878093},{"tid":59861212129,"amount":1000000,"price":12500000000,"date":1377840783}]
        @Override
        public AllTrades deserialize(final JsonElement json,  final Type typeOfT, final JsonDeserializationContext context)
                throws JsonParseException {
            final JsonArray jsonAsksArray = json.getAsJsonArray(); // array of trades
            final AllTrades allTrades = new AllTrades(new ArrayList<TradeVO>());
            TradeVO tradeVO ;
            for (int i = 0; i < jsonAsksArray.size(); i++) {
                tradeVO = new TradeVO();
                JsonObject jsonObject = jsonAsksArray.get(i).getAsJsonObject();

                Long tid = jsonObject.get("tid").getAsLong();
                Double amount = jsonObject.get("amount").getAsDouble();
                Double price = jsonObject.get("price").getAsDouble();
                Long date = jsonObject.get("date").getAsLong();

                tradeVO.setTid(tid);
                tradeVO.setAmount(amount);
                tradeVO.setPrice(price);
                tradeVO.setDate(date);

                allTrades.getTrades().add(tradeVO);
            }
            return allTrades;
        }
    }

