package com.acme.mytrader.price;

import com.acme.mytrader.execution.ExecutionService;

public class PriceListenerService implements PriceListener {
    private ExecutionService executionService;
    private PriceSource priceSource;
    private String stock;
    private final double level;
    private final int quantity;

    public PriceListenerService(ExecutionService executionService, PriceSource priceSource, String stock, double level, int quantity) {
        this.executionService = executionService;
        this.priceSource = priceSource;
        this.stock = stock;
        this.level = level;
        this.quantity = quantity;
        this.priceSource.addPriceListener(this);
    }

    @Override
    public void priceUpdate(String security, double price) {
        if (security.equals(stock) && price < level) {
            executionService.buy(security, price, quantity);
        }
    }

}
