package com.gridnine.testing;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights(); //создали полеты и поместили в Лист

        FBeforeTimeNow1 fBeforeTimeNow1 = new FBeforeTimeNow1(); // создание 1 фильтра/правила
        FComparDepArrive2 fComparDepArrive2 = new FComparDepArrive2(); // создание 2 фильта/правила
        FTimeBetweenSegment3_1 fTimeBetweenSegment3_1 = new FTimeBetweenSegment3_1(); // создание 3.1 фильта/правила
        FTimeBetweenSegment3_2 fTimeBetweenSegment3_2 = new FTimeBetweenSegment3_2();

        List<Flight> list = fBeforeTimeNow1.filter(flights); // проверка первого правила
        fComparDepArrive2.filter(flights); // проверка второго правила
        fTimeBetweenSegment3_1.filter(flights);
        fTimeBetweenSegment3_2.filter(flights);
    }

}
