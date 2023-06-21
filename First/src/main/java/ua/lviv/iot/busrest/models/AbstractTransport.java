package ua.lviv.iot.busrest.models;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "@class")
public abstract class AbstractTransport {
    private int restId;
    private int identifier;
    private double maxSpeed;
    private double currentSpeed;
    public AbstractTransport(
            final int identifier, final double maxSpeed,
            final double currentSpeed) {
        this.identifier = identifier;
        this.maxSpeed = maxSpeed;
        this.currentSpeed = currentSpeed;
    }
    public String[] getHeaders() {
        return new String[]{"identifier", "maxSpeed", "currentSpeed"};
    }
    public String[] getToCSV() {
        return new String[]{String.valueOf(identifier),
                String.valueOf(maxSpeed), String.valueOf(currentSpeed)};
    }
    public abstract void accelerate(int speed);
}