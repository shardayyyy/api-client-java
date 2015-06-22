package com.ice3x.api.sample.entity;

import java.util.Date;

/**
 * Created by folashade.adeyosoye on 6/18/2015.
 */
public class TradeVO {
    //[{"tid":4432702312,"amount":10000000,"price":14000000000,"date":1378878093},{"tid":59861212129,"amount":1000000,"price":12500000000,"date":1377840783}]
    private long tid;
    private long amount;
    private long price;
    private long date;

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String toString(String json) {
        String str = "";
        str += "\n===========================================";
        str += "\n=============   Trade   ==============";
        str += "\n===" + json + "==";
        str += "\n===========================================";
        str += "\nTid = " + tid;
        str += "\nAmount = " + amount;
        str += "\nPrice = " + price;
        str += "\nDate = " + date;
        return str;
    }
}
