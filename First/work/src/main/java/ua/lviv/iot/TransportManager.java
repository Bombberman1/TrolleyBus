package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
import lombok.*;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ToString

public class TransportManager {
    static LinkedList<Transport> list = new LinkedList<Transport>();
    static void addTransport(final Transport temp){
        list.add(temp);
    }
    static LinkedList<Transport> findAllWithIdGreaterThan(int x){
        return list.stream().filter(temp -> temp.getId() > x).collect(Collectors.toCollection(LinkedList::new));
        //toCollection(LinkedList::new));
        //greater.forEach(temp -> System.out.println(temp));
    }
    static LinkedList<Transport> findAllWithCurrentSpeed(){
        return list.stream().filter(temp -> temp.getCurrentSpeed() > 0).collect(Collectors.toCollection(LinkedList::new));
        //speed.forEach(temp -> System.out.println(temp));
    }
    static LinkedList<TrolleyBus> findAllWithPassengers(){
        return list.stream().filter(temp -> temp instanceof TrolleyBus).map(temp -> (TrolleyBus) temp).filter(temp -> temp.getPassengers() > 9).collect(Collectors.toCollection(LinkedList::new));
    }
    public static void main(String[] args) {
        TrolleyBus trolleyBus = new TrolleyBus(50, 80, 0, 13, "Lviv", 30, 10);
        Car car = new Car(78, 4, 120, 30, 50, 600, 90);
        Car car2 = new Car(21, 2, 80, 0, 20, 400, 120);
        TrolleyBus trolleyBus2 = new TrolleyBus(47, 90, 40, 39, "Kyiv", 30, 20);
        Bus bus = new Bus(140, 12, 80, 20);
        Bus bus2 = new Bus();
        MotorBike motorBike = new MotorBike(90, 130, 15, true);
        MotorBike motorBike2 = new MotorBike();
        addTransport(trolleyBus);
        addTransport(car);
        for(var object : list) {
            System.out.println(object);
        }
        System.out.print("\n");
        addTransport(car2);
        addTransport(trolleyBus2);
        addTransport(bus);
        addTransport(bus2);
        addTransport(motorBike);
        addTransport(motorBike2);
        System.out.println(findAllWithIdGreaterThan(60));
        System.out.print("\n");
        System.out.println(findAllWithCurrentSpeed());
        //Transport transport1 = list.get(0);
        //((TrolleyBus) transport1).stop();
        System.out.print("\n");
        System.out.println(findAllWithPassengers());
    }
}