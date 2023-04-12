package ua.lviv.iot;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Getter
@Setter
@NoArgsConstructor
public final class MotorBike extends AbstractTransport {
    private boolean hasMuffler = false;
    public MotorBike(final int identifier, final double maxSpeed,
                     final double currentSpeed, final boolean hasMuffler) {
        super(identifier, maxSpeed, currentSpeed);
        this.hasMuffler = hasMuffler;
    }
    public void accelerate(final int speed) {
        setCurrentSpeed(getMaxSpeed());
    }
}