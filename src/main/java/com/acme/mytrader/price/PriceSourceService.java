package com.acme.mytrader.price;

import java.util.List;

public class PriceSourceService implements PriceSource{

    private List<PriceListener> listenerList;

    public PriceSourceService(List<PriceListener> listenerList) {
        this.listenerList = listenerList;
    }

    @Override
    public void addPriceListener(PriceListener listener) {
        listenerList.add(listener);
    }

    @Override
    public void removePriceListener(PriceListener listener) {
        listenerList.remove(listener);
    }
}
