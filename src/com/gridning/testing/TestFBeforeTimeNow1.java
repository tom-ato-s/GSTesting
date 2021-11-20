package com.gridning.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestFBeforeTimeNow1 {
   private List<Flight> execut = new ArrayList<>();
    List<Flight> flights;
    List<Flight> result;
    @Before
    public void testBefore() {
       flights = FlightBuilder.createFlights();
       execut.add(flights.get(2));
    }
    @Test
    public void testFilter(){
        FBeforeTimeNow1 fBeforeTimeNow1 = new FBeforeTimeNow1();
        result = fBeforeTimeNow1.filter(flights);
        Assert.assertEquals(execut, result);
    }



}
