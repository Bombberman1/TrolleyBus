package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Bus extends Transport {
    public int id;
    public int windows;
    public double maxSpeed;
    public double currentSpeed = 0;
    public void accelerate(int speed){currentSpeed = 40;}
}