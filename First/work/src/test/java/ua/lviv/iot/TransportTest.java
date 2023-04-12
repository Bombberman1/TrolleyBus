package ua.lviv.iot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TransportTest {
    public AbstractTransport object;
    @BeforeEach
    public void addToClass(){
        object = new Car(42, 120, 30, 4, 25, 400, 90);
    }
    @Test
    public void classCreationTest(){
        Assertions.assertNotNull(object);
        object.setIdentifier(69);
        object.setCurrentSpeed(60);
        Assertions.assertEquals(69, object.getIdentifier());
        Assertions.assertEquals(60, object.getCurrentSpeed());
    }
}