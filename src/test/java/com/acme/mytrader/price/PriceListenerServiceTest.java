package com.acme.mytrader.price;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.internal.verification.VerificationModeFactory.atLeastOnce;

import com.acme.mytrader.execution.ExecutionService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class PriceListenerServiceTest {

    @Mock
    private ExecutionService executionService;

    @Mock
    private PriceSource priceSource;


    @Before
    public void setup() {
        initMocks(this);
    }

    @Test
    public void shouldBeAbleToBuyStockWhenPriceReduced() {
        final PriceListener priceListener = new PriceListenerService(executionService, priceSource, "IBM", 80, 100);
        priceListener.priceUpdate("IBM", 75);
        verify(executionService, atLeastOnce()).buy("IBM", 75, 100);
    }


    @Test
    public void shouldNotBuyStockWhenPriceIncreased() {
        final PriceListener priceListener = new PriceListenerService(executionService, priceSource, "IBM", 80, 100);
        priceListener.priceUpdate("IBM", 85);
        verify(executionService, never()).buy("IBM", 85, 100);
        ;
    }
}