package com.ice3x.api.sample.entity;

import java.util.*;

/**
 * Created by folashade.adeyosoye on 6/18/2015.
 */
public class OrderBookVO {
    //https://api.ice3x.com/market/BTC/ZAR/orderbook
    //{"currency":"ZAR",
    // "instrument":"BTC",
    // "timestamp":1378941290,
    // "asks":[[14000000000,20000000],[14100000000,10000000],[14200000000,20000000],[14600000000,10000000],[15900000000,50000000],[16000000000,10000000]],
    // "bids":[[13700000000,20000000],[12500000000,20000000],[12000010000,100000000],[12000000000,1000000]]}

    private String currency;
    private String instrument;
    private long timestamp;
    private List<AskVO> asks;
    private List<BidVO> bids;



    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<AskVO> getAsks() {
        return asks;
    }

    public void setAsks(List<AskVO> asks) {
        this.asks = asks;
    }

    public List<BidVO> getBids() {
        return bids;
    }

    public void setBids(List<BidVO> bids) {
        this.bids = bids;
    }

    public String toString(String json) {
        String str = "";
        str += "\n===========================================";
        str += "\n=============   Order Book   ==============";
        str += "\n===" + json + "==";
        str += "\n===========================================";
        str += "\nCurrency = " + currency;
        str += "\nInstrument = " + instrument;
        str += "\nTimestamp = " + timestamp;
        str += "\nDate = " + new Date(timestamp);
        str += "\n " + asks.size() + " ASKS";
        str += "\n-------------------------------";
        for (AskVO ask : asks) {
            str += "\n[Ask = " + ask.getAsk() + " and Volume = " + ask.getVolume() + "]";
        }
        str += "\n " + bids.size() + " BIDS";
        str += "\n-------------------------------";
        for (BidVO bid : bids) {
            str += "\n[Bid = " + bid.getBid() + " and Volume = " + bid.getVolume() + "]";
        }
        return str;
    }
}
