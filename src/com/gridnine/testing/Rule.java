package com.gridnine.testing;

import java.util.List;

abstract class Rule implements Filters{

    protected static String rule; // правило отбора
    protected static boolean toBy; //есть элементы фильтра
    protected static List<Flight> allList; // входящий лист в фильтр
    protected static List<Flight> filterList;  // выходящий лист из фильтра

    @Override
    public List<Flight>filter(List<Flight> list) {
        return list;
    }

    public static void printFlight(List<Flight> filterList) {
        System.out.println(rule);
        if(toBy) {

            for (Flight flight:filterList)
                System.out.print(flight.toString() + " ");
        } else {
            System.out.println("Полетов для данного фильтра не существует");
        }
        System.out.println(" ");
    }
}
