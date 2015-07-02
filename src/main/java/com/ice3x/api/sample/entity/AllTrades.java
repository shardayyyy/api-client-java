package com.ice3x.api.sample.entity;

import java.util.List;

/**
 * Created by folashade.adeyosoye on 6/18/2015.
 */
public class AllTrades {
    //[{"tid":4432702312,"amount":10000000,"price":14000000000,"date":1378878093},{"tid":59861212129,"amount":1000000,"price":12500000000,"date":1377840783}]
    private List<TradeVO> trades;

    public AllTrades(List<TradeVO> trades) {
        this.trades = trades;
    }

    public List<TradeVO> getTrades() {
        return trades;
    }

    public void setTrades(List<TradeVO> trades) {
        this.trades = trades;
    }

    public String toString() {
        String str = "";
        for (TradeVO t : trades){
            str += "\n===========================================";
            str += "\nTid    = " + t.getTid();
            str += "\nAmount = " + t.getAmount();
            str += "\nPrice  = " + t.getPrice();
            str += "\nDate   = " + t.getDate();
            str += "\n===========================================";
        }
        return str;
    }
}
