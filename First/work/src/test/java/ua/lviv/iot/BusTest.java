package ua.lviv.iot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BusTest {
    public Bus object;
    @BeforeEach
    public void addToClass(){
        object = new Bus(56, 110, 40, 10);
    }
    @Test
    public void accelerateTest(){
        object.accelerate(80);
        Assertions.assertEquals(object.getCurrentSpeed(), object.getMaxSpeed());
    }
    @Test
    public void setWindowsTest(){
        object.setWindows(14);
        Assertions.assertEquals(14, object.getWindows());
    }
}