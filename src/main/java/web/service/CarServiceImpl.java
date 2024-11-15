package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars(int count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Mazda", "pizdaten", 1));
        cars.add(new Car("Mazda", "pizdaten", 2));
        cars.add(new Car("Mazda", "pizdaten", 3));
        cars.add(new Car("Mazda", "pizdaten", 4));
        cars.add(new Car("Mazda", "pizdaten", 5));
        cars.add(new Car("Mazda", "pizdaten", 6));
        if (count < cars.size() && count > 0) {
            return cars.subList(0, count);
        } else {
            return cars;
        }
    }
}
