package ua.lviv.iot.busrest.writer;

import com.opencsv.CSVWriter;
import ua.lviv.iot.busrest.models.AbstractTransport;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public final class Writer {
    public void writeToFile(final LinkedList<AbstractTransport> transports) {
        final Path path = Paths.get("separated.csv");
        if (!transports.isEmpty()) {
            try (Scanner scanner = new Scanner(new InputStreamReader(
                    Files.newInputStream(path), StandardCharsets.UTF_8))) {
                if (!scanner.hasNext()) {
                    try (CSVWriter object = new CSVWriter(new OutputStreamWriter(
                            Files.newOutputStream(path), StandardCharsets.UTF_8))) {
                        transports.sort(new CompareObjectListUtils());
                        AbstractTransport last = transports.getLast();
                        for (AbstractTransport temp : transports) {
                            if (last.getClass() != temp.getClass()) {
                                object.writeNext(temp.getHeaders());
                            }
                            object.writeNext(temp.getToCSV());
                            last = temp;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}