package ua.lviv.iot.busrest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lviv.iot.busrest.manager.TransportManager;
import ua.lviv.iot.busrest.models.*;

import java.util.LinkedList;

public class TransportManagerTest{
    public TransportManager managerTester;
    @BeforeEach
    public void addToManager(){
        managerTester = new TransportManager();
        TrolleyBus trolleyBus = new TrolleyBus(50, 80, 0, 13, "Lviv", 30, 10);
        Car car = new Car(78, 120, 30, 4, 50, 600, 90);
        Car car2 = new Car(21, 80, 0, 2, 20, 400, 120);
        TrolleyBus trolleyBus2 = new TrolleyBus(47, 90, 40, 39, "Kyiv", 30, 20);
        Bus bus = new Bus(140, 120, 80, 20);
        Bus bus2 = new Bus();
        MotorBike motorBike = new MotorBike(90, 130, 15, true);
        MotorBike motorBike2 = new MotorBike();
        managerTester.getList().add(trolleyBus);
        managerTester.getList().add(car);
        managerTester.getList().add(car2);
        managerTester.getList().add(trolleyBus2);
        managerTester.getList().add(bus);
        managerTester.getList().add(bus2);
        managerTester.getList().add(motorBike);
        managerTester.getList().add(motorBike2);
    }
    @Test
    public void addTransportTest(){
        MotorBike temp = new MotorBike(48, 92, 70, true);
        managerTester.addTransport(temp);
        Assertions.assertTrue(managerTester.getList().contains(temp));
    }
    @Test
    public void findAllWithIdGreaterThanTest(){
        LinkedList<AbstractTransport> expected = new LinkedList<>();
        expected.add(managerTester.getList().get(1));  // car
        expected.add(managerTester.getList().get(4));  // bus
        expected.add(managerTester.getList().get(6));  // motorBike
        Assertions.assertEquals(expected, managerTester.findAllWithIdGreaterThan(60));
    }
    @Test
    public void findAllWithCurrentSpeedTest(){
        LinkedList<AbstractTransport> expected = new LinkedList<>();
        expected.add(managerTester.getList().get(1));  // car
        expected.add(managerTester.getList().get(3));  // trolleyBus2
        expected.add(managerTester.getList().get(4));  // bus
        expected.add(managerTester.getList().get(6));  // motorBike
        Assertions.assertEquals(expected, managerTester.findAllWithCurrentSpeed());
    }
    @Test
    public void findAllTrolleyBusWithPassengersTest(){
        LinkedList<TrolleyBus> expected = new LinkedList<>();
        expected.add((TrolleyBus) managerTester.getList().get(0));  // trolleyBus
        expected.add((TrolleyBus) managerTester.getList().get(3));  // trolleyBus2
        Assertions.assertEquals(expected, managerTester.findAllTrolleyBusWithPassengers());
    }
    @Test
    public void findAllCarWithDoorsTest(){
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(((Car) managerTester.getList().get(1)).getDoors());  // car
        expected.add(((Car) managerTester.getList().get(2)).getDoors());  // car2
        Assertions.assertEquals(expected, managerTester.findAllCarWithDoors());
    }
    @Test
    public void findMotorBikeWithMufflerTest(){
        LinkedList<Boolean> expected = new LinkedList<>();
        expected.add(((MotorBike) managerTester.getList().get(6)).isHasMuffler());  // motorBike
        Assertions.assertEquals(expected, managerTester.findMotorBikeWithMuffler());
    }
    @Test
    public void castTest(){
        Assertions.assertEquals(120, ((Bus) managerTester.getList().get(4)).getMaxSpeed());
    }
}