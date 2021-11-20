////Абстактный класс, материнский для правил/фильтров

package com.gridning.testing;
import java.util.List;

    abstract class Rule implements Filters{
    protected boolean toBy = false; //есть элементы перелетов при данной фильтрации
    protected List<Flight> filterList;  // исходящий лист перелетов из фильтра
    protected List<Segment> listSegments; // лист сегментов в полете

    @Override
    public List<Flight>filter(List<Flight> list) { // метод фильтрации перелетов, который будут переопределять классы наследники
        return list;
    }


    public void addFlight(Flight flight){
        if (!filterList.contains(flight)) // если полет еще не добавлен в массив
            filterList.add(flight);
    }

}
