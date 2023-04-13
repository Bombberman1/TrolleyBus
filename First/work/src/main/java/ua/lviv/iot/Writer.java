package ua.lviv.iot;

import com.opencsv.CSVWriter;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public final class Writer {
    public void writeToFile(final LinkedList<AbstractTransport> transports,
                            final Comparator<AbstractTransport> comparator)
            throws Exception {
        final Path path = Paths.get("..\\separated.csv");
        Scanner scanner = new Scanner(new InputStreamReader(
                Files.newInputStream(path), StandardCharsets.UTF_8));
            CSVWriter object;
            if (transports.isEmpty()) {
                scanner.close();
                throw new Exception("List is empty");
            } else if (scanner.hasNext()) {
                scanner.close();
                throw new Exception("CSV already exists");
            } else {
                scanner.close();
                Collections.sort(transports, comparator);
                object = new CSVWriter(new OutputStreamWriter(
                        Files.newOutputStream(path), StandardCharsets.UTF_8));
                AbstractTransport last = transports.getLast();
                for (AbstractTransport temp : transports) {
                    if (last.getClass() != temp.getClass()) {
                        object.writeNext(temp.getHeaders());
                    }
                    object.writeNext(temp.toCSV());
                    last = temp;
                }
                object.close();
            }
        /*catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            object.close();
        }
        if(transports.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }*/
    }

    /*public static void main(String[] args) throws Exception {
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
        LinkedList<AbstractTransport> trans = new LinkedList<>();
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
        Writer writer = new Writer();
        LinkedList<AbstractTransport> listok = new LinkedList<>();
        writer.writeToFile(trans);
    }*/
}