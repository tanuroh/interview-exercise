package com.acme.mytrader.strategy;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;

import com.acme.mytrader.price.PriceListener;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class TradingStrategyTest {

    @Mock
    private PriceListener priceListener;

    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void shouldAddPriceListenerAndCheckForPriceUpdate() {
        final TradingStrategy tradingStrategy = new TradingStrategy(priceListener);
        tradingStrategy.checkStock("IBM", 40);
        verify(priceListener, atLeastOnce()).priceUpdate("IBM", 40);
    }
}
