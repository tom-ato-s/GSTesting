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
        // проверка пустой ли лист полетов
        if(allList.isEmpty()) return filterList;
        //перебор по всем полетам
        for (Flight flight : allList) { // перебор по всем полетам
            listSegments = flight.getSegments();
            // проверка пустой ли лист сегментов
            if(listSegments.isEmpty()) continue;
            // перебор по всем сегментам полетя
            for (Segment segment : listSegments) {
                //из сегмента значения отлета и прилета присваеваем переменным
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
