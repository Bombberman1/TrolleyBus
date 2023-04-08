package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class TrolleyBus extends Transport{
    private int routeNumber;
    private String currentStop;
    private int capacity;
    private int passengers;
    public TrolleyBus(int id, double maxSpeed, double currentSpeed, int routeNumber, String currentStop, int capacity, int passengers){
        super(id, maxSpeed, currentSpeed);
        this.routeNumber = routeNumber;
        this.currentStop = currentStop;
        this.capacity = capacity;
        this.passengers = passengers;
    }
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