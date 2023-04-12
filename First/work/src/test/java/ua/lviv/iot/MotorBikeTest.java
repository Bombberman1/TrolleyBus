package ua.lviv.iot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MotorBikeTest {
    public MotorBike object;
    @BeforeEach
    public void addToClass(){
        object = new MotorBike(15, 110, 70, true);
    }
    @Test
    public void accelerateTest(){
        object.accelerate(100);
        Assertions.assertEquals(object.getCurrentSpeed(), object.getMaxSpeed());
    }
    @Test
    public void setHasMufflerTest(){
        object.setHasMuffler(false);
        Assertions.assertFalse(object.isHasMuffler());
    }
}