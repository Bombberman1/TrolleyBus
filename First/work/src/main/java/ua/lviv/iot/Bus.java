package ua.lviv.iot;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Getter
@Setter
@NoArgsConstructor

public final class Bus extends AbstractTransport {
    private int windows;
    public Bus(final int identifier, final double maxSpeed,
               final double currentSpeed, final int windows) {
        super(identifier, maxSpeed, currentSpeed);
        this.windows = windows;
    }
    public void accelerate(final int speed) {
        setCurrentSpeed(getMaxSpeed());
    }
}