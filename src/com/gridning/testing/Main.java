package com.gridning.testing;

import java.util.*;


public class Main {

    public static void main(String[] args) {
        //создание полетов в Лист
        List<Flight> flights = FlightBuilder.createFlights(); //создали полеты и поместили в Лист

        //создание фильтров
        FBeforeTimeNow1 fBeforeTimeNow1 = new FBeforeTimeNow1();
        FComparDepArrive2 fComparDepArrive2 = new FComparDepArrive2();
        FTimeBetweenSegment3 fTimeBetweenSegment3 = new FTimeBetweenSegment3();

        //применение фильтров
        List<Flight> one = fBeforeTimeNow1.filter(flights);
        List<Flight> two = fComparDepArrive2.filter(flights);
        List<Flight> thee = fTimeBetweenSegment3.filter(flights);

        // печать результатов
        System.out.println("Filter fBeforeTimeNow1 result:");
        Print.printFlights(one);
        System.out.println("Filter fComparDepArrive2 result");
        Print.printFlights(two);
        System.out.println("Filter fTimeBetweenSegment3_1 result:");
        Print.printFlights(thee);
    }

}

class Print{  // класс для печати результатов
    public static void printFlights(List<Flight> filterList) {
        if (filterList.isEmpty()) {
            System.out.println("Лист перелетов пуст");
        }else {
             for (Flight flight : filterList) {
                 if(flight.getSegments().isEmpty()) {
                     System.out.println("Лист сегментов пуст в перелете");
                 } else  System.out.println(flight.toString());
             }
        }
    }
}
