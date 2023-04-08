package ua.lviv.iot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrolleyBusTest {
    public TrolleyBus object;
    @BeforeEach
    public void addToClass(){
        object = new TrolleyBus(40, 90, 30, 20, "Lytsk", 50, 20);
    }
    @Test
    public void accelerateTest(){
        int speed1 = 40;
        object.accelerate(speed1);
        Assertions.assertEquals(speed1, object.getCurrentSpeed());
        int speed2 = 120;
        object.accelerate(speed2);
        Assertions.assertEquals(object.getMaxSpeed(), object.getCurrentSpeed());
        object.setMaxSpeed(130);
        object.accelerate(speed2);
        Assertions.assertEquals(speed2, object.getCurrentSpeed());
    }

    @Test
    public void stopTest(){
        object.stop();
        Assertions.assertEquals(0, object.getCurrentSpeed());
    }

    @Test
    public void startTest(){
        object.start();
        Assertions.assertEquals(45, object.getCurrentSpeed());
    }

    @Test
    public void addPassengerTest(){
        object.addPassenger();
        Assertions.assertEquals(21, object.getPassengers());
        object.setPassengers(object.getCapacity());
        object.addPassenger();
        Assertions.assertEquals(50, object.getPassengers());
    }

    @Test
    public void removePassengerTest(){
        object.removePassenger();
        Assertions.assertEquals(19, object.getPassengers());
        object.setPassengers(0);
        object.removePassenger();
        Assertions.assertEquals(0, object.getPassengers());
    }
    @Test
    public void noArgsConstructorTest(){
        object = new TrolleyBus();
        Assertions.assertEquals(0, object.getRouteNumber());
    }
    @Test
    public void getCurrentStopTest(){
        Assertions.assertEquals("Lytsk", object.getCurrentStop());
    }
    @Test
    public void settersTest(){
        object.setRouteNumber(72);
        object.setCurrentStop("Kherson");
        object.setCapacity(60);
        Assertions.assertEquals(72, object.getRouteNumber());
        Assertions.assertEquals("Kherson", object.getCurrentStop());
        Assertions.assertEquals(60, object.getCapacity());
    }
}