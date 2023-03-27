package ua.lviv.iot.algo.part1.lab1.TrolleyBus;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)

public class MotorBike extends Transport {
    public boolean hasMuffler = false;
    public MotorBike(int id, double maxSpeed, double currentSpeed, boolean hasMuffler){
        super(id, maxSpeed, currentSpeed);
        this.hasMuffler = hasMuffler;
    }
    public void accelerate(int speed){currentSpeed = speed;}
}