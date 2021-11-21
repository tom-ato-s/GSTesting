package com.gridning.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class TestFTimeBetweenSegment3 {
    private List<Flight> execut = new ArrayList<>();
    List<Flight> flights;
    List<Flight> result;

    //генерация данных перед проверкой
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

    // Проверять на AssertionError пустой список
    @Test (expected = AssertionError.class)
    public void emptyEnterList_for_rm() throws NullPointerException {
        List<Flight> ex = List.of();
        Assert.assertEquals((ex) , result);
    }

    // Проверять AssertionError Лист сегментов
    @Test (expected = AssertionError.class)
    public void emptySegmentsList() throws NullPointerException {
        List<Flight> ex = new ArrayList<>();
        List<Segment> segments =  List.of();
        Flight flight = new Flight(segments);
        execut.add(flight);
        ex.addAll(execut);
        //ex = null;
        Assert.assertEquals(ex, result);
    }
}