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
    @Override
    public String[] getHeaders() {
        return new String[]{super.getHeaders()[0], super.getHeaders()[1], super.getHeaders()[2], "hasMuffler"};
    }
    @Override
    public String[] toCSV() {
        return new String[]{super.toCSV()[0], super.toCSV()[1], super.toCSV()[2], String.valueOf(hasMuffler)};
    }
    public void accelerate(final int speed) {
        setCurrentSpeed(getMaxSpeed());
    }
}