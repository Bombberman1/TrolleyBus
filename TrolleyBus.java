package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
<<<<<<< HEAD
import lombok.*;
=======

import lombok.*;

>>>>>>> d1791ae31b46249e94ab40d3ecf0b7b4e08f3522
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@NoArgsConstructor
public class TrolleyBus {
    private int id = 100;
    private int routeNumber;
    private String currentStop;
    private double maxSpeed;
    private double currentSpeed;
    private int capacity;
    private int passengers;

<<<<<<< HEAD
public class TrolleyBus extends Transport{
    private int id = 100;
    private int routeNumber;
    private String currentStop;
    private double maxSpeed;
    private double currentSpeed;
    private int capacity;
    private int passengers;
    public void accelerate(int speed) {
        if(speed < maxSpeed){
            currentSpeed = speed;
        }
        else{
            currentSpeed = maxSpeed;
        }
    }
    private static TrolleyBus instance = new TrolleyBus();
    private static TrolleyBus getInstance() {
        return instance;
    }
=======
    private static TrolleyBus instance = new TrolleyBus();

    private static TrolleyBus getInstance() {
        return instance;
    }

    public void stop() {
        currentSpeed = 0;
    }
>>>>>>> d1791ae31b46249e94ab40d3ecf0b7b4e08f3522

    public void start() {
        currentSpeed = 20;
    }

<<<<<<< HEAD
    /*public static void main(String[] args) {
        TrolleyBus[] trolleyBuses = {
        new TrolleyBus(50, 13, "Lviv", 80, 0, 30, 10),
        instance.getInstance(),
        instance.getInstance(),
        new TrolleyBus()};
        for(var trolleyBus : trolleyBuses ) {
            System.out.println(trolleyBus);
        }
    }*/
}
=======
    public void addPassenger() {
        if (passengers < capacity) {
            passengers++;
        }
    }

    public void removePassenger() {
        if (passengers > 0) {
            passengers--;
        }
    }

    public static void main(String[] args) {
        TrolleyBus[] trolleyBuses = {
                new TrolleyBus(50, 13, "Lviv", 80, 0, 30, 10),
                instance.getInstance(),
                instance.getInstance(),
                new TrolleyBus()};
        for (var trolleyBus : trolleyBuses) {
            System.out.println(trolleyBus);
        }
    }
}
>>>>>>> d1791ae31b46249e94ab40d3ecf0b7b4e08f3522
