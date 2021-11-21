//Фильтр
// 3 общее время, проведённое на земле превышает два часа
//            (общее время-время между двумя соседними пересадками,
//          хотя бы 2 соседних пересадки соответствуют правилу)";

package com.gridning.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FTimeBetweenSegment3 extends Rule{
    private LocalDateTime start; // время прилета в точку пересадки
    private LocalDateTime fin;  // время отлета з точки пересадки
    int index; // индекс сегмента в массиве
    //переопределение метола filter
    @Override
    public List<Flight> filter(List<Flight> allList) {
        //создаем исходящий массив
        filterList = new ArrayList<>();
        // проверка пустой ли лист полетов
        if(allList.isEmpty()) return filterList;
        // перебор по всем полетам
        for (Flight flight : allList) {
            listSegments = flight.getSegments();
            // проверка пустой ли лист сегментов
            if(listSegments.isEmpty()) continue;
            //Проверка наличия в листе сегментов 1 элемента
            if(listSegments.size() == 1) continue;
            // перебор по всем сегментам полета
            for (Segment segment : listSegments) {
                index = listSegments.indexOf(segment);
                // если первый элемент листа сегментов
                if(index == 0) {
                    start = segment.getArrivalDate();
                } else {
                    //если не первый элемент листа сегментов
                    fin = segment.getDepartureDate();
                    // если время пересадка больше 2 часов
                    if (fin.isAfter(start.plusHours(2))) {
                        // добавляем полет в лист
                        addFlight(flight);
                        start = segment.getArrivalDate();
                    } else {
                        // если текущий сегмент последний в листе;
                        if (index == (listSegments.size() - 1)) {
                        } else start = segment.getArrivalDate();
                    }
                }
            }
        }
        return filterList;
    }
}
