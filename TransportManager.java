package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
import lombok.*;

import java.util.LinkedList;
import java.util.stream.Stream;

@ToString

public class TransportManager {
    static LinkedList<Transport> list = new LinkedList<Transport>();
    static void addTransport(final Transport temp){
        list.add(temp);
    }
    static void findAllWithIdGreaterThan(int x){
        Stream<Transport> greater = list.stream().filter(temp -> temp.getId() > x);
        greater.forEach(temp -> System.out.println(temp));
    }
    static void findAllWithCurrentSpeed(){
        Stream<Transport> speed = list.stream().filter(temp -> temp.getCurrentSpeed() > 0);
        speed.forEach(temp -> System.out.println(temp));
    }
    public static void main(String[] args) {
        TrolleyBus trolleyBus = new TrolleyBus(50, 13, "Lviv", 80, 0, 30, 10);
        Car car = new Car(78, 4, 120, 30, 50, 600, 90);
        Car car2 = new Car(21, 2, 80, 0, 20, 400, 120);
        TrolleyBus trolleyBus2 = new TrolleyBus(47, 39, "Anal", 90, 40, 30, 20);
        Bus bus = new Bus(140, 12, 80, 20);
        Bus bus2 = new Bus();
        MotorBike motorBike = new MotorBike(90, 130, 15, true);
        MotorBike motorBike2 = new MotorBike();
        addTransport(trolleyBus);
        addTransport(car);
        for(var object : list) {
            System.out.println(object);
        }
        System.out.printf("\n");
        addTransport(car2);
        addTransport(trolleyBus2);
        addTransport(bus);
        addTransport(bus2);
        addTransport(motorBike);
        addTransport(motorBike2);
        findAllWithIdGreaterThan(60);
        System.out.printf("\n");
        findAllWithCurrentSpeed();
    }
}