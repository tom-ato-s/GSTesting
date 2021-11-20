package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class FBeforeTimeNow1 extends Rule{
    FBeforeTimeNow1() {
        rule = "1. вылет до текущего момента времени (перебор по каждому сегменту перелета)";
    }
@Override
    public List<Flight> filter(List<Flight> allList) {
        for(Flight flight: allList) { // перебор по всем полетам
            if(isEmptyListFlights(allList)) break;
            listSegments = flight.getSegments();
            for (Segment segment : listSegments) { // перебор по всем сегментам полета
                if(isEmptyListSegments(listSegments)) break;
                LocalDateTime departureDate = segment.getDepartureDate();
                LocalDateTime nowTime = LocalDateTime.now();
                if(departureDate.isBefore(nowTime)) { // сравниваем дату отправления и текущую дату
                    addToFilterList(flight);
                }
            }
        }
        if(toBy == false) filterList = new ArrayList<>();
        printFlights(rule, filterList, toBy, emptyListFlights);
    return filterList;
    }


}
