package com.acme.mytrader.price;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class PriceSourceServiceTest {

    @Mock
    private PriceListener priceListenerMock;

    private List<PriceListener> listenerList = new ArrayList<>();

    @InjectMocks
    private PriceSource priceSource = new PriceSourceService(listenerList);

    @Test
    public void shouldBeAbleToAddPriceListener() {
        priceSource.addPriceListener(priceListenerMock);
        assertThat(listenerList.size(), is(1));
        assertThat(listenerList.get(0), is(priceListenerMock));
    }

    @Test
    public void shouldBeAbleToRemovePriceListener() {
        priceSource.removePriceListener(priceListenerMock);
        assertThat(listenerList.size(), is(0));
    }

}