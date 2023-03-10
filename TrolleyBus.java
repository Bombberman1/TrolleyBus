package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
import lombok.*;

import java.lang.reflect.Constructor;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class TrolleyBus{
    private int id;
    private int routeNumber;
    private String currentStop;
    private double maxSpeed;
    private double currentSpeed;
    private int capacity;
    private int passengers;

    public TrolleyBus(){
        this.id = 100;
    }

    private static TrolleyBus instance = new TrolleyBus();
    private static TrolleyBus getInstance() {
        return instance;
    }

    public void stop(){
        currentSpeed = 0;
    }
    public void start(){
        currentSpeed = 20;
    }
    public void addPassenger(){
        if(passengers < capacity){
            passengers++;
        }
    }
    public void removePassenger(){
        if(passengers > 0){
            passengers--;
        }
    }

    public static void main(String[] args) {
        TrolleyBus[] bus = new TrolleyBus[7];
        bus[0] = new TrolleyBus(50, 13, "Lviv", 80, 0, 30, 10);
        bus[1] = instance.getInstance();
        bus[2] = new TrolleyBus();
        for(int i = 0; i < 3; i++){
            System.out.println(bus[i]);
        }
        bus[0].start();
        System.out.println(bus[0]);
        bus[0].addPassenger();
        System.out.println(bus[0]);
        bus[0].removePassenger();
        System.out.println(bus[0]);
        bus[0].stop();
        System.out.println(bus[0]);
    }
}