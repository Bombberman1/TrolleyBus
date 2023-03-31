package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)

public class Car extends Transport{
    private int doors;
    private double trunkVolume;
    private double maxWeight;
    private double currentWeight;
    public Car(int id, double maxSpeed, double currentSpeed, int doors, double trunkVolume, double maxWeight, double currentWeight){
        super(id, maxSpeed, currentSpeed);
        this.doors = doors;
        this.trunkVolume = trunkVolume;
        this.maxWeight = maxWeight;
        this.currentWeight = currentWeight;
    }
    public void accelerate(int speed){
        currentSpeed = 20;
    }
    /*@Override
    public String toString(){
        return String.format("%s %s %s %s %s %s %s", id, doors, maxSpeed, currentSpeed, trunkVolume, maxWeight, currentWeight);
    }*/
}