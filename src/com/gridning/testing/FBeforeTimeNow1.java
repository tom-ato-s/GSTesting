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
        //перебор по всем полетам
        for(Flight flight: allList) {
            // проверка пустой ли лист полетов
            if(allList.isEmpty()) break;
            listSegments = flight.getSegments();
            //перебор по всем сегментам полета
            for (Segment segment : listSegments) {
                // проверка пустой ли лист сегментов
                if(listSegments.isEmpty()) break;
                LocalDateTime departureDate = segment.getDepartureDate();
                LocalDateTime nowTime = LocalDateTime.now();
                // сравниваем дату отправления и текущую дату
                if(departureDate.isBefore(nowTime)) {
                    // если true условиям - добавляем полет в лист
                    addFlight(flight);
                }
            }
        }
    return filterList;
    }
}
