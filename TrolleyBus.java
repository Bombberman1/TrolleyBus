package ua.lviv.iot.algo.part1.lab1.TrolleyBus;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
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

    private static TrolleyBus instance = new TrolleyBus();

    private static TrolleyBus getInstance() {
        return instance;
    }

    public void stop() {
        currentSpeed = 0;
    }

    public void start() {
        currentSpeed = 20;
    }

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
