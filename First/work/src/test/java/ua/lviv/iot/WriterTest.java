package ua.lviv.iot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

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
        trans = new LinkedList<>();
        trans.add(trolleyBus);
        trans.add(trolleyBus2);
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
    public void writeToFileEmptyTest() {
        LinkedList<AbstractTransport> listok = new LinkedList<>();
        Exception exception1 = Assertions.assertThrows(Exception.class, () -> writer.writeToFile(listok));
        Assertions.assertEquals("List is empty", exception1.getMessage());
    }
    @Test
    public void writeToFileExistTest() {
        Exception exception2 = Assertions.assertThrows(Exception.class, () -> writer.writeToFile(trans));
        Assertions.assertEquals("CSV already exists", exception2.getMessage());
    }
    @Test
    public void writeToFileCSVTest() throws Exception {
        Scanner scanner = new Scanner(new File("C:\\Users\\sasad\\IdeaProjects\\First\\separated.csv"));
        LinkedList<String> expect = new LinkedList<>();
        LinkedList<String> actual = new LinkedList<>();
        Comparator<AbstractTransport> comparator = new CompareClass();
        Collections.sort(trans, comparator);
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
            }
            else return;
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
            expect.add(rawName);
            expect.add(rawValue);
        }
        while (scanner.hasNext()) {
            actual.add(scanner.next());
        }
        writer.writeToFile(trans);
        Assertions.assertEquals(expect, actual);
    }
}