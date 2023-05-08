package ua.lviv.iot.busrest.models;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public final class MotorBike extends AbstractTransport {
    private boolean hasMuffler = false;
    public MotorBike(final int identifier, final double maxSpeed,
                     final double currentSpeed, final boolean hasMuffler) {
        super(identifier, maxSpeed, currentSpeed);
        this.hasMuffler = hasMuffler;
    }
    @Override
    public String[] getHeaders() {
        return new String[]{super.getHeaders()[0], super.getHeaders()[1],
                super.getHeaders()[2], "hasMuffler"};
    }
    @Override
    public String[] getToCSV() {
        return new String[]{super.getToCSV()[0], super.getToCSV()[1],
                super.getToCSV()[2], String.valueOf(hasMuffler)};
    }
    public void accelerate(final int speed) {
        setCurrentSpeed(getMaxSpeed());
    }
}