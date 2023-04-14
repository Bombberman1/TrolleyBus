package ua.lviv.iot;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("PMD.ShortClassName")

public final class Bus extends AbstractTransport {
    private int windows;
    public Bus(final int identifier, final double maxSpeed,
               final double currentSpeed, final int windows) {
        super(identifier, maxSpeed, currentSpeed);
        this.windows = windows;
    }
    @Override
    public String[] getHeaders() {
        return new String[]{super.getHeaders()[0],
                super.getHeaders()[1], super.getHeaders()[2], "windows"};
    }
    @Override
    public String[] toCSV() {
        return new String[]{super.toCSV()[0], super.toCSV()[1],
                super.toCSV()[2], String.valueOf(windows)};
    }
    public void accelerate(final int speed) {
        setCurrentSpeed(getMaxSpeed());
    }
}