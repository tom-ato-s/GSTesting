//Фильтр
// 2. имеются сегменты с датой прилёта раньше даты вылета

package com.gridning.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class FComparDepArrive2 extends Rule {

    //переопределение метола filter
    @Override
    public List<Flight> filter(List<Flight> allList) {
        //создаем исходящий массив
        filterList = new ArrayList<>();
        //перебор по всем полетам
        for (Flight flight : allList) { // перебор по всем полетам
            // проверка пустой ли лист полетов
            if(allList.isEmpty()) break;
            listSegments = flight.getSegments();
            // перебор по всем сегментам полета
            for (Segment segment : listSegments) {
                if(listSegments.isEmpty()) break;
                LocalDateTime dep = segment.getDepartureDate();
                LocalDateTime arr = segment.getArrivalDate();
                // сравнение даты прилета и отлета
                if (arr.isBefore(dep)) {
                    // добавляем полет в лист
                    addFlight(flight);
                }
            }
        }
        return filterList;
    }
}
