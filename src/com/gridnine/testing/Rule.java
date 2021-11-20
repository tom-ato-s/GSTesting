package com.gridnine.testing;
//Абстактный класс, материнский для правил/фильтров

import java.util.ArrayList;
import java.util.List;

abstract class Rule implements Filters{

    protected  String rule; // текст правило отбора
    protected boolean toBy = false; //есть элементы перелетов при данной фильтрации
    protected boolean emptyListFlights = false; // лист перелетов пуст
    protected boolean emptyListSegments = false; // лист перелетов пуст
    protected List<Flight> allList; // входящий лист перелетов  в фильтр
    protected List<Flight> filterList;  // исходящий лист перелетов из фильтра
    protected List<Segment> listSegments; // лист сегментов в полете

    @Override
    public List<Flight>filter(List<Flight> list) { // метод фильтрации перелетов, который будут переопределять классы наследники
        return list;
    }

    public boolean isEmptyListFlights(List<Flight> filterList) {
        if(filterList.isEmpty())
            emptyListFlights = true;
        return emptyListFlights;
    }

    public boolean isEmptyListSegments(List<Segment> filterList) {
        if(filterList.isEmpty())
            emptyListSegments = true;
        return emptyListSegments;
    }

    public void addToFilterList(Flight flight){
        if (toBy == false) {
            // если это первый отобранный полет - создается массив полетов
            filterList = new ArrayList<>();
            filterList.add(flight);
            toBy = true; // ставится пометка, для печати полетов - есть отобранные полеты
        } else {
            if (!filterList.contains(flight)) // если полет еще не добавлен в массив
                filterList.add(flight);
        }
    }

    public static void printFlights(String rule, List<Flight> filterList, boolean toBy, boolean emptyListFlights) { //общий метод печати перелетов после фильтрации
        System.out.println(rule);
        if (emptyListFlights) {
            System.out.println("Лист перелетов пуст, фильтрация не возможна");
        }else {
            if (toBy) {
                for (Flight flight : filterList)
                    System.out.println(flight.toString());
            } else {
                System.out.println("Полетов для данного фильтра не существует");
            }
        }
        System.out.println(" ");
    }

}
