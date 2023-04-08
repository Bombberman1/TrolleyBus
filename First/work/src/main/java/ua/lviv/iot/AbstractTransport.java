package ua.lviv.iot;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractTransport {
    private int identifier;
    private double maxSpeed;
    private double currentSpeed;
    public abstract void accelerate(int speed);
}