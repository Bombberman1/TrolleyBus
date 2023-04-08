package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

public class Bus extends Transport {
    private int windows;
    public Bus(int id, double maxSpeed, double currentSpeed, int windows){
        super(id, maxSpeed, currentSpeed);
        this.windows = windows;
    }
    public void accelerate(int speed){currentSpeed = 40;}
}