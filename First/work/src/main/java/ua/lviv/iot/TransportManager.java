package ua.lviv.iot;
import lombok.Getter;
import java.util.LinkedList;
import java.util.stream.Collectors;
@Getter
public final class TransportManager {
    private final LinkedList<AbstractTransport> list = new LinkedList<>();
    public void addTransport(final AbstractTransport temp) {
        list.add(temp);
    }
    public LinkedList<AbstractTransport>
    findAllWithIdGreaterThan(final int number) {
        return list.stream()
                    .filter(temp -> temp.getIdentifier() > number)
                    .collect(Collectors.toCollection(LinkedList::new));
        //toCollection(LinkedList::new));
        //greater.forEach(temp -> System.out.println(temp));
    }
    public LinkedList<AbstractTransport> findAllWithCurrentSpeed() {
        return list.stream()
                    .filter(temp -> temp.getCurrentSpeed() > 0)
                    .collect(Collectors.toCollection(LinkedList::new));
        //speed.forEach(temp -> System.out.println(temp));
    }
    public LinkedList<TrolleyBus> findAllTrolleyBusWithPassengers() {
        return list.stream()
                    .filter(temp -> temp instanceof TrolleyBus)
                    .map(temp -> (TrolleyBus) temp)
                    .filter(temp -> temp.getPassengers() > 0)
                    .collect(Collectors.toCollection(LinkedList::new));
    }
    public LinkedList<Integer> findAllCarWithDoors() {
        return list.stream()
                    .filter(object -> object instanceof Car)
                    .map(mapper -> ((Car) mapper).getDoors())
                    .filter(temp -> temp > 0)
                    .collect(Collectors.toCollection(LinkedList::new));
    }
    public LinkedList<Boolean> findMotorBikeWithMuffler() {
        return list.stream()
                    .filter(object -> object instanceof MotorBike)
                    .map(object -> ((MotorBike) object).isHasMuffler())
                    .filter(object -> object)
                    .collect(Collectors.toCollection(LinkedList::new));
    }
    /*public static void main(String[] args) {
        TransportManager manager = new TransportManager();
        TrolleyBus trolleyBus = new TrolleyBus(50, 80, 0, 13, "Lviv", 30, 10);
        Car car = new Car(78, 4, 120, 30, 50, 600, 90);
        Car car2 = new Car(21, 2, 80, 0, 20, 400, 120);
        TrolleyBus trolleyBus2 = new TrolleyBus(47, 90, 40, 39, "Kyiv", 30, 20);
        Bus bus = new Bus(140, 12, 80, 20);
        Bus bus2 = new Bus();
        MotorBike motorBike = new MotorBike(90, 130, 15, true);
        MotorBike motorBike2 = new MotorBike();
        manager.addTransport(trolleyBus);
        manager.addTransport(car);
        for(var object : manager.list) {
            //System.out.println(object);
        }
        System.out.print("\n");
        manager.addTransport(car2);
        manager.addTransport(trolleyBus2);
        manager.addTransport(bus);
        manager.addTransport(bus2);
        manager.addTransport(motorBike);
        manager.addTransport(motorBike2);
        System.out.println(manager.findAllWithIdGreaterThan(60));
        System.out.print("\n");
        System.out.println(manager.findAllWithCurrentSpeed());
        System.out.print("\n");
        System.out.println(manager.findAllTrolleyBusWithPassengers());
        System.out.print("\n");
        System.out.println(manager.findAllCarWithDoors());
        System.out.print("\n");
        System.out.println(manager.findMotorBikeWithMuffler());
    }*/
}