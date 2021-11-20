package com.gridning.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestFTimeBetweenSegment3_1 {
    private List<Flight> execut = new ArrayList<>();
    List<Flight> flights;
    List<Flight> result;

    @Before
    public void testBefore() {
        flights = FlightBuilder.createFlights();
        execut.add(flights.get(4));
    }

    @Test
    public void testFilter() {
        FTimeBetweenSegment3 fTimeBetweenSegment3_1 = new FTimeBetweenSegment3();
        result = fTimeBetweenSegment3_1.filter(flights);
        Assert.assertEquals(execut, result);
    }
}