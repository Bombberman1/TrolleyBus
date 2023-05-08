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
public final class Car extends AbstractTransport {
    private int doors;
    private double trunkVolume;
    private double maxWeight;
    private double currentWeight;
    public Car(final int identifier,
               final double maxSpeed, final double currentSpeed,
               final int doors, final double trunkVolume,
               final double maxWeight, final double currentWeight) {
        super(identifier, maxSpeed, currentSpeed);
        this.doors = doors;
        this.trunkVolume = trunkVolume;
        this.maxWeight = maxWeight;
        this.currentWeight = currentWeight;
    }
    @Override
    public String[] getHeaders() {
        return new String[]{super.getHeaders()[0],
                super.getHeaders()[1], super.getHeaders()[2], "doors",
                "trunkVolume", "maxWeight", "currentWeight"};
    }
    @Override
    public String[] getToCSV() {
        return new String[]{super.getToCSV()[0],
                super.getToCSV()[1], super.getToCSV()[2],
                String.valueOf(doors), String.valueOf(trunkVolume),
                String.valueOf(maxWeight), String.valueOf(currentWeight)};
    }
    public void accelerate(final int speed) {
        setCurrentSpeed(getMaxSpeed());
    }
    /*@Override
    public String toString(){
        return String.format("%s %s %s %s %s %s %s", id, doors,
        maxSpeed, currentSpeed, trunkVolume, maxWeight, currentWeight);
    }*/
}