package ua.lviv.iot;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Getter
@Setter
@NoArgsConstructor
public final class TrolleyBus extends AbstractTransport {
    private int routeNumber;
    private String currentStop;
    private int capacity;
    private int passengers;
    public TrolleyBus(final int identifier,
                      final double maxSpeed, final double currentSpeed,
                      final int routeNumber, final String currentStop,
                      final int capacity, final int passengers) {
        super(identifier, maxSpeed, currentSpeed);
        this.routeNumber = routeNumber;
        this.currentStop = currentStop;
        this.capacity = capacity;
        this.passengers = passengers;
    }
    @Override
    public String[] getHeaders() {
        return new String[]{super.getHeaders()[0], super.getHeaders()[1], super.getHeaders()[2], "routeNumber", "currentStop", "capacity", "passengers"};
    }
    @Override
    public String[] toCSV() {
        return new String[]{super.toCSV()[0], super.toCSV()[1], super.toCSV()[2], String.valueOf(routeNumber), String.valueOf(currentStop), String.valueOf(capacity), String.valueOf(passengers)};
    }
    public void accelerate(final int speed) {
        if (speed < getMaxSpeed()) {
            setCurrentSpeed(speed);
        } else {
            setCurrentSpeed(getMaxSpeed());
        }
    }
    public void stop() {
        setCurrentSpeed(0);
    }
    public void start() {
        setCurrentSpeed(getMaxSpeed() / 2);
    }
    public void addPassenger() {
        if (passengers < capacity) {
            passengers++;
        }
    }
    public void removePassenger() {
        if (passengers > 0) {
            passengers--;
        }
    }
}