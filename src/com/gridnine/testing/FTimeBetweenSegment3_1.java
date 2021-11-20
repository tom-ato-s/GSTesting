package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FTimeBetweenSegment3_1 extends Rule{
    private LocalDateTime start; // время прилета в точку пересадки
    private LocalDateTime fin;  // время отлета з точки пересадки
    int index; // индекс сегмента в массиве
    FTimeBetweenSegment3_1() {
    rule = "3.1 общее время, проведённое на земле превышает два часа" + "\n" +
            "(общее время-время между двумя соседними пересадками, " +
            "хоты бы одна пересадка соответствует правилу)";
    }

    @Override
    public List<Flight> filter(List<Flight> allList) {
        for (Flight flight : allList) { // перебор по всем полетам
           if(isEmptyListFlights(allList)) break;
            listSegments = flight.getSegments();

                for (Segment segment : listSegments) { // перебор по всем сегментам полета,
                    if(isEmptyListSegments(listSegments)) break;
                    index = listSegments.indexOf(segment);

                    if(index == 0) {
                        start = segment.getArrivalDate();
                    } else {
                        fin = segment.getDepartureDate();
                        if (fin.isAfter(start.plusHours(2))) {   // если время пересадка больше 2 часов
                            addToFilterList(flight);  // добавляем элемент в массив перелетов
                            start = segment.getArrivalDate();
                        } else {

                            if (index == (listSegments.size() - 1)) { // если текущий сегмент последний в листе;
                            } else start = segment.getArrivalDate();;
                        }
                    }
                }
        }
         if(!toBy) filterList = new ArrayList<>();
         printFlights(rule, filterList, toBy, emptyListFlights);
        return filterList;
    }

}
