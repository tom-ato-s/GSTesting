package com.gridning.testing;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        List<Flight> flights = FlightBuilder.createFlights(); //создали полеты и поместили в Лист

        FBeforeTimeNow1 fBeforeTimeNow1 = new FBeforeTimeNow1(); // создание 1 фильтра/правила
        FComparDepArrive2 fComparDepArrive2 = new FComparDepArrive2(); // создание 2 фильта/правила
        FTimeBetweenSegment3 fTimeBetweenSegment3 = new FTimeBetweenSegment3(); // создание 3 фильта/правила


        List<Flight> one = fBeforeTimeNow1.filter(flights); // проверка первого правила
        List<Flight> two = fComparDepArrive2.filter(flights); // проверка второго правила
        List<Flight> thee = fTimeBetweenSegment3.filter(flights);
        System.out.println("Filter fBeforeTimeNow1 result:");
        Print.printFlights(one);
        System.out.println("Filter fComparDepArrive2 result");
        Print.printFlights(two);
        System.out.println("Filter fTimeBetweenSegment3_1 result:");
        Print.printFlights(thee);
    }

}

class Print{
    public static void printFlights(List<Flight> filterList) { //общий метод печати перелетов после фильтрации
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
