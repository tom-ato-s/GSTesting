// 1. вылет до текущего момента времени

package com.gridning.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class FBeforeTimeNow1 extends Rule{
    FBeforeTimeNow1() {
    }
@Override
    public List<Flight> filter(List<Flight> allList) {
    filterList = new ArrayList<>();
        for(Flight flight: allList) { // перебор по всем полетам
            if(allList.isEmpty()) break;
            listSegments = flight.getSegments();
            for (Segment segment : listSegments) { // перебор по всем сегментам полета
                if(listSegments.isEmpty()) break;
                LocalDateTime departureDate = segment.getDepartureDate();
                LocalDateTime nowTime = LocalDateTime.now();
                if(departureDate.isBefore(nowTime)) { // сравниваем дату отправления и текущую дату
                    addFlight(flight);  // добавляем полет в лист
                }
            }
        }

    return filterList;
    }


}
