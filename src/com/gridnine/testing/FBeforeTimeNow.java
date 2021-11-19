package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class FBeforeTimeNow extends Rule{
    FBeforeTimeNow() {
        rule = "1. вылет до текущего момента времени";
        toBy = false; //есть элементы фильтра

    }
@Override
    public List<Flight> filter(List<Flight> allList) {

    this.allList = allList;
    for(Flight flight: allList) { // перебор по всем полетам
            // перебор по всем сегментам полета, взят первый элемент, взята дата отправления
            LocalDateTime departureDate = flight.getSegments().get(0).getDepartureDate();
            LocalDateTime nowTime = LocalDateTime.now();
            // сравниваем дату отправления и текущую дату
            boolean before = departureDate.isBefore(nowTime);
            if(before) {
                filterList = new ArrayList<>();
                filterList.add(flight);
                toBy = true;
            }
        }
      //  printFlight(rule, filterList, toBy);
    return filterList;
    }


}
