package com.ice3x.api.sample.marketapi;

/**
 * Created by folashade.adeyosoye on 6/19/2015.
 */
public class Tick {
    //{"bestBid":13700000000,"bestAsk":14000000000,"lastPrice":14000000000,"currency":"ZAR","instrument":"BTC","timestamp":1378878117}
    private Long bestBid;
    private Long bestAsk;
    private Long lastPrice;
    private String currency;
    private String instrument;
    private long timestamp;


    public Long getBestBid() {
        return bestBid;
    }

    public void setBestBid(Long bestBid) {
        this.bestBid = bestBid;
    }

    public Long getBestAsk() {
        return bestAsk;
    }

    public void setBestAsk(Long bestAsk) {
        this.bestAsk = bestAsk;
    }

    public Long getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Long lastPrice) {
        this.lastPrice = lastPrice;
    }

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
}
