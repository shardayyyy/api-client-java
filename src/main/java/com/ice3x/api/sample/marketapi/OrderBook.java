package com.ice3x.api.sample.marketapi;

import com.ice3x.api.sample.entity.AsksOffers;
import com.ice3x.api.sample.entity.BidsOffers;
import com.ice3x.api.sample.entity.MarketBase;

import java.util.List;

/**
 * Created by folashade.adeyosoye on 6/18/2015.
 */
public class OrderBook extends MarketBase {
    //https://api.ice3x.com/market/BTC/ZAR/orderbook
    //{"currency":"ZAR",
    // "instrument":"BTC",
    // "timestamp":1378941290,
    // "asks":[[14000000000,20000000],[14100000000,10000000],[14200000000,20000000],[14600000000,10000000],[15900000000,50000000],[16000000000,10000000],
    // "bids":[[13700000000,20000000],[12500000000,20000000],[12000010000,100000000],[12000000000,1000000]]}

    private String currency;
    private String instrument;
    private long timestamp;
    private List<AsksOffers> asks;
    private List<BidsOffers> bids;

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

    public List<AsksOffers> getAsks() {
        return asks;
    }

    public void setAsks(List<AsksOffers> asks) {
        this.asks = asks;
    }

    public List<BidsOffers> getBids() {
        return bids;
    }

    public void setBids(List<BidsOffers> bids) {
        this.bids = bids;
    }
}
