package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FComparDepArrive2 extends Rule {

    public FComparDepArrive2() {
        rule = "2. имеются сегменты с датой прилёта раньше даты вылета";
    }

    @Override
    public List<Flight> filter(List<Flight> allList) {
        for (Flight flight : allList) { // перебор по всем полетам
            if(isEmptyListFlights(allList)) break;
            listSegments = flight.getSegments();
            for (Segment segment : listSegments) { // перебор по всем сегментам полета
                if(isEmptyListSegments(listSegments)) break;
                LocalDateTime dep = segment.getDepartureDate();
                LocalDateTime arr = segment.getArrivalDate();
                if (arr.isBefore(dep)) {
                    addToFilterList(flight);
                }
            }
        }
        if(toBy == false) filterList = new ArrayList<>();
        printFlights(rule, filterList, toBy, emptyListFlights);
        return filterList;
    }
}
