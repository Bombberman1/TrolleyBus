package ua.lviv.iot;

import com.opencsv.CSVWriter;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WriterTest {
    public Writer writer;
    public LinkedList<AbstractTransport> trans;
    public Comparator<AbstractTransport> comparator1;
    public Comparator<AbstractTransport> comparator2;
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
        comparator1 = new CompareClass();
        comparator2 = new CompareClass2();
    }
    @Test
    @Order(1)
    public void writeToFileEmptyTest() {
        LinkedList<AbstractTransport> listok = new LinkedList<>();
        Exception exception1 = Assertions.assertThrows(Exception.class, () -> writer.writeToFile(listok, comparator2));
        Assertions.assertEquals("List is empty", exception1.getMessage());
    }
    @Test
    @Order(2)
    public void writeToFileExistTest() throws FileNotFoundException {
        if((new Scanner(new File("..\\separated.csv")).hasNext())) {
            Exception exception2 = Assertions.assertThrows(Exception.class, () -> writer.writeToFile(trans, comparator2));
            Assertions.assertEquals("CSV already exists", exception2.getMessage());
        }
        else {
            Assertions.assertFalse((new Scanner(new File("..\\separated.csv")).hasNext()));
        }
    }
    @Test
    @Order(3)
    public void writeToFileCSVTestOld() throws Exception {
        CSVWriter csv = new CSVWriter(new FileWriter("..\\separated.csv"));
        writer.writeToFile(trans, comparator1);
        Scanner scanner = new Scanner(new File("..\\separated.csv"));
        LinkedList<String> expect = new LinkedList<>();
        LinkedList<String> actual = new LinkedList<>();
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
        Assertions.assertEquals(expect, actual);
    }
    @Test
    @Order(4)
    public void writeToFileCSVTestNew() throws Exception {
        CSVWriter csv = new CSVWriter(new FileWriter("..\\separated.csv"));
        writer.writeToFile(trans, comparator2);
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