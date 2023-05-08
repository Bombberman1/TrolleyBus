package ua.lviv.iot.busrest.models;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Getter
@Setter
@NoArgsConstructor
@SuppressWarnings("PMD.ShortClassName")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")

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
    public String[] getToCSV() {
        return new String[]{super.getToCSV()[0], super.getToCSV()[1],
                super.getToCSV()[2], String.valueOf(windows)};
    }
    public void accelerate(final int speed) {
        setCurrentSpeed(getMaxSpeed());
    }
}