package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Car extends Transport{
    public int id;
    public int doors;
    public double maxSpeed;
    public double currentSpeed;
    public double trunkVolume;
    public double maxWeight;
    public double currentWeight;
    public void accelerate(int speed){
        currentSpeed = 20;
    }
    /*@Override
    public String toString(){
        return String.format("%s %s %s %s %s %s %s", id, doors, maxSpeed, currentSpeed, trunkVolume, maxWeight, currentWeight);
    }*/
}