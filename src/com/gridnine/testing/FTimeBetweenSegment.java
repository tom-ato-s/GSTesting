//package com.gridnine.testing;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class FTimeBetweenSegment extends Rule{
//    LocalDateTime start;
//    LocalDateTime fin;
//    FTimeBetweenSegment() {
//    rule = "3. общее время, проведённое на земле превышает два часа";
//    toBy = false; //есть элементы фильтра
//
//    }
//
//    @Override
//    public List<Flight> filter(List<Flight> allList) {
//           this.allList = allList;
//        for (Flight flight : allList) { // перебор по всем полетам
//            // перебор по всем сегментам полета,
//            listSegments = flight.getSegments();
//            if(listSegments.size() > 1) {
//                for (Segment segment : listSegments) {
//                    if(segment.)
//                    start = segment.getArrivalDate();
//
//
//                }
//
//            }
//
//
//
//        }
//        printFlight(rule, filterList, toBy);
//        return filterList;
//    }
//
//}
