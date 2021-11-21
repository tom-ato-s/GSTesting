package com.gridning.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestFComparDepArrive2 {
    private List<Flight> execut = new ArrayList<>();
    List<Flight> flights;
    List<Flight> result;
    //генерация данных перед проверкой
    @Before
    public void testBefore() {
        flights = FlightBuilder.createFlights();
        execut.add(flights.get(3));
    }

    @Test
    public void testFilter() {
        FComparDepArrive2 fComparDepArrive2 = new FComparDepArrive2();
        result = fComparDepArrive2.filter(flights);
        Assert.assertEquals(execut, result);
    }
}