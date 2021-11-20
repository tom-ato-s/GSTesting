//2. имеются сегменты с датой прилёта раньше даты вылета


package com.gridning.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FComparDepArrive2 extends Rule {

    public FComparDepArrive2() {
    }

    @Override
    public List<Flight> filter(List<Flight> allList) {
        filterList = new ArrayList<>();
        for (Flight flight : allList) { // перебор по всем полетам
            if(allList.isEmpty()) break;
            listSegments = flight.getSegments();
            for (Segment segment : listSegments) { // перебор по всем сегментам полета
                if(listSegments.isEmpty()) break;
                LocalDateTime dep = segment.getDepartureDate();
                LocalDateTime arr = segment.getArrivalDate();
                if (arr.isBefore(dep)) {
                    addFlight(flight);  // добавляем полет в лист
                }
            }
        }

        return filterList;
    }
}
