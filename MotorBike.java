package ua.lviv.iot.algo.part1.lab1.TrolleyBus;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class MotorBike extends Transport {
    public int id;
    public double maxSpeed;
    public double currentSpeed;
    public boolean hasMuffler = false;
    public void accelerate(int speed){currentSpeed = speed;}
}
