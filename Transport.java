package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public abstract class Transport{
    public int id;
    public double maxSpeed;
    public double currentSpeed;

    public abstract void accelerate(int speed);
}