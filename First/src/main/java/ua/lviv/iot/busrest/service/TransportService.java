package ua.lviv.iot.busrest.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.lviv.iot.busrest.models.AbstractTransport;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


@Service
public final class TransportService {
    private final Map<Integer, AbstractTransport> transport = new HashMap<>();
    private int nextAvailableId = 1;

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public TransportService singleton() {
        return new TransportService();
    }

    public LinkedList<AbstractTransport> getTransport() {
        return new LinkedList<>(transport.values());
    }

    public ResponseEntity<AbstractTransport>
    getTransportById(final Integer transportId) {
        if (transport.get(transportId) != null) {
            return new ResponseEntity<>(
                    transport.get(transportId), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public AbstractTransport createTransport(
            final AbstractTransport abstractTransport) {
        abstractTransport.setRestId(nextAvailableId++);
        transport.put(abstractTransport.getRestId(), abstractTransport);
        return abstractTransport;
    }

    public ResponseEntity<AbstractTransport> deleteTransportById(
            final Integer transportId) {
        return transport.remove(transportId) == null
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.status(HttpStatus.OK).build();
    }

    public ResponseEntity<AbstractTransport> updateTransportById(
            final Integer transportId,
            final AbstractTransport abstractTransport) {
        if (transport.get(transportId) != null) {
            abstractTransport.setRestId(transportId);
            transport.put(transportId, abstractTransport);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
