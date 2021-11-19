package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FComparDepArrive extends Rule {

    private List<Segment> listSegments; // массив сегментов в полете

    public FComparDepArrive() {
        rule = "2. имеются сегменты с датой прилёта раньше даты вылета";
        toBy = false; //есть элементы фильтра
    }

    @Override
    public List<Flight> filter(List<Flight> allList) {
        this.allList = allList;
        if(allList.isEmpty())
            throw new NoSuchElementException();
        for (Flight flight : allList) { // перебор по всем полетам
            // перебор по всем сегментам полета,
            listSegments = flight.getSegments();
            for (Segment segment : listSegments) {
                LocalDateTime dep = segment.getDepartureDate();
                LocalDateTime arr = segment.getArrivalDate();
                boolean before = arr.isBefore(dep);
                if (before) {
                    if (toBy == false) {
                        filterList = new ArrayList<>();
                        toBy = true;
                    }
                    if (!filterList.contains(flight))
                        filterList.add(flight);
                }
            }
        }
        //printFlight(rule, filterList, toBy);
        return filterList;
    }
}
