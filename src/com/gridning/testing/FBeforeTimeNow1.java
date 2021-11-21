// Фильтр:
// 1. вылет до текущего момента времени

package com.gridning.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class FBeforeTimeNow1 extends Rule{

    //переопределение метола filter
    @Override
    public List<Flight> filter(List<Flight> allList) {
        //создаем исходящий массив
        filterList = new ArrayList<>();
        // проверка пустой ли лист полетов
        if(allList.isEmpty()){
           // throw new NullPointerException ("Error");}
            return filterList;}
            //перебор по всем полетам
        for(Flight flight: allList) {
            listSegments = flight.getSegments();
            // проверка пустой ли лист сегментов
            if(listSegments.isEmpty()) continue;
            //перебор по всем сегментам полета
            for (Segment segment : listSegments) {
                LocalDateTime departureDate = segment.getDepartureDate();
                LocalDateTime nowTime = LocalDateTime.now();
                // Если время отправления в сегменте раньше текущего времени
                if(departureDate.isBefore(nowTime)) {
                    // добавляем полет в лист
                    addFlight(flight);
                }
            }
        }
    return filterList;
    }
}
