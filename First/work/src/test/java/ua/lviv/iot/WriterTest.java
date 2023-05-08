package ua.lviv.iot;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WriterTest {
    public Writer writer;
    public LinkedList<AbstractTransport> trans;
    @BeforeEach
    public void data() {
        writer = new Writer();
        TrolleyBus trolleyBus = new TrolleyBus(50, 80, 0, 13, "Lviv", 30, 10);
        Car car = new Car(78, 4, 120, 30, 50, 600, 90);
        Car car2 = new Car(21, 2, 80, 0, 20, 400, 120);
        TrolleyBus trolleyBus2 = new TrolleyBus(47, 90, 40, 39, "Kyiv", 30, 20);
        Bus bus = new Bus(140, 12, 80, 20);
        Bus bus2 = new Bus();
        MotorBike motorBike = new MotorBike(90, 130, 15, true);
        MotorBike motorBike2 = new MotorBike();
        TrolleyBus trolleyBus3 = new TrolleyBus(140, 90, 40, 52, "Odesa", 30, 10);
        TrolleyBus trolleyBus4 = new TrolleyBus(20, 85, 0, 81, "Kharkiv", 20, 7);
        MotorBike motorBike3 = new MotorBike(92, 80, 60, true);
        trans = new LinkedList<>();
        trans.add(trolleyBus);
        trans.add(trolleyBus2);
        trans.add(motorBike3);
        trans.add(car);
        trans.add(car2);
        trans.add(bus);
        trans.add(bus2);
        trans.add(motorBike);
        trans.add(motorBike2);
        trans.add(trolleyBus3);
        trans.add(trolleyBus4);
    }
    @Test
    @Order(1)
    public void writeToFileCSVTestOld() throws IOException {
        writer.writeToFile(trans);
        Scanner scanner = new Scanner(new File("..\\separated.csv"));
        LinkedList<String> expect = new LinkedList<>();
        LinkedList<String> actual = new LinkedList<>();
        trans.sort(new CompareObjectListUtils());
        AbstractTransport last = trans.getLast();
        for (AbstractTransport object : trans) {
            String rawName = "";
            boolean first = true;
            if (last.getClass() != object.getClass()) {
                for (String temp : object.getHeaders()) {
                    if (first) {
                        rawName = "\"" + temp + "\"";
                        first = false;
                    }
                    else {
                        rawName += ",\"" + temp + "\"";
                    }
                }
                last = object;
                expect.add(rawName);
                first = true;
                String rawValue = "";
                for (String temp : object.toCSV()) {
                    if (first) {
                        rawValue = "\"" + temp + "\"";
                        first = false;
                    }
                    else {
                        rawValue += ",\"" + temp + "\"";
                    }
                }
                expect.add(rawValue);
            }
            else {
                String rawValue = "";
                for (String temp : object.toCSV()) {
                    if (first) {
                        rawValue = "\"" + temp + "\"";
                        first = false;
                    }
                    else {
                        rawValue += ",\"" + temp + "\"";
                    }
                }
                expect.add(rawValue);
            }
        }
        while (scanner.hasNext()) {
            actual.add(scanner.next());
        }
        Assertions.assertEquals(expect, actual);
    }
    @Test
    @Order(2)
    public void writeToFileCSVTestNew() throws IOException {
        writer.writeToFile(trans);
        Scanner scanner1 = new Scanner(new File("..\\expectingFile.csv"));
        Scanner scanner2 = new Scanner(new File("..\\separated.csv"));
        LinkedList<String> expect = new LinkedList<>();
        LinkedList<String> actual = new LinkedList<>();
        while (scanner1.hasNext()) {
            expect.add(scanner1.next());
        }
        while (scanner2.hasNext()) {
            actual.add(scanner2.next());
        }
        Assertions.assertEquals(expect, actual);
    }
}