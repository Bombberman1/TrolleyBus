package ua.lviv.iot.busrest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.busrest.models.Car;

public class CarTest {
    public Car object;
    @BeforeEach
    public void addToClass(){
        object = new Car(97, 140, 60, 4, 30, 600, 100);
    }
    @Test
    public void accelerateTest(){
        object.accelerate(30);
        Assertions.assertEquals(object.getCurrentSpeed(), object.getMaxSpeed());
    }
    @Test
    public void noArgsConstructorTest(){
        object = new Car();
        object.setDoors(6);
        object.setTrunkVolume(35);
        object.setMaxWeight(700);
        object.setCurrentWeight(105);
        Assertions.assertEquals(6, object.getDoors());
        Assertions.assertEquals(35, object.getTrunkVolume());
        Assertions.assertEquals(700, object.getMaxWeight());
        Assertions.assertEquals(105, object.getCurrentWeight());
    }
}