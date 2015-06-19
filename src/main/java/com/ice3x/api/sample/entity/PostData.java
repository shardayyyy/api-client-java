package com.ice3x.api.sample.entity;

/**
 * Created by folashade.adeyosoye on 6/18/2015.
 */
public class PostData{
    //{"currency":"ZAR","instrument":"BTC","price":13000000000,"volume":10000000,"orderSide":"Bid","ordertype":"Limit","clientRequestId":"1"}";
    private String currency;
    private String instrument;
    private Long price ;
    private Number volume;
    private String orderSide;
    private String ordertype;
    private String clientRequestId;

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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Number getVolume() {
        return volume;
    }

    public void setVolume(Number volume) {
        this.volume = volume;
    }

    public String getOrderSide() {
        return orderSide;
    }

    public void setOrderSide(String orderSide) {
        this.orderSide = orderSide;
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype;
    }

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }
}


