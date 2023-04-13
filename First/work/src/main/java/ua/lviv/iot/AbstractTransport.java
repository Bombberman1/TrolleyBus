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
    public String[] getHeaders() {
        return new String[]{"identifier", "maxSpeed", "currentSpeed"};
    }
    public String[] toCSV() {
        return new String[]{String.valueOf(identifier),
                String.valueOf(maxSpeed), String.valueOf(currentSpeed)};
    }
    public abstract void accelerate(int speed);
}