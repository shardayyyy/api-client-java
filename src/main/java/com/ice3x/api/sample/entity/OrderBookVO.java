package com.ice3x.api.sample.entity;

import java.util.List;

/**
 * Created by folashade.adeyosoye on 6/18/2015.
 */
public class OrderBookVO {
    //https://api.ice3x.com/market/BTC/ZAR/orderbook
    //{"currency":"ZAR",
    // "instrument":"BTC",
    // "timestamp":1378941290,
    // "asks":[[14000000000,20000000],[14100000000,10000000],[14200000000,20000000],[14600000000,10000000],[15900000000,50000000],[16000000000,10000000],
    // "bids":[[13700000000,20000000],[12500000000,20000000],[12000010000,100000000],[12000000000,1000000]]}

    private String currency;
    private String instrument;
    private long timestamp;
    private List<AsksOffersVO> asks;
    private List<BidsOffersVO> bids;

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

    public List<AsksOffersVO> getAsks() {
        return asks;
    }

    public void setAsks(List<AsksOffersVO> asks) {
        this.asks = asks;
    }

    public List<BidsOffersVO> getBids() {
        return bids;
    }

    public void setBids(List<BidsOffersVO> bids) {
        this.bids = bids;
    }
}
