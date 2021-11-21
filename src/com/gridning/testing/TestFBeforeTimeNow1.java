package com.gridning.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestFBeforeTimeNow1 {
   private List<Flight> execut = new ArrayList<>();
    List<Flight> flights;
    List<Flight> result;

    //генерация данных перед проверкой
    @Before
    public void testBefore() {
       flights = FlightBuilder.createFlights();
    }
    @Test // тест осуществляет работу по результату созданных данных
    public void testFilterAll(){
        execut.add(flights.get(2));
        FBeforeTimeNow1 fBeforeTimeNow1 = new FBeforeTimeNow1();
        result = fBeforeTimeNow1.filter(flights);
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
