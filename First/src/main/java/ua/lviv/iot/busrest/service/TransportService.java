package ua.lviv.iot.busrest.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
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

    public AbstractTransport
    getTransportById(final Integer transportId) {
        return transport.get(transportId);
    }

    public AbstractTransport createTransport(
            final AbstractTransport abstractTransport) {
        abstractTransport.setRestId(nextAvailableId++);
        transport.put(abstractTransport.getRestId(), abstractTransport);
        return abstractTransport;
    }

    public AbstractTransport deleteTransportById(
            final Integer transportId) {
        return transport.remove(transportId);
    }

    public AbstractTransport updateTransportById(
            final Integer transportId,
            final AbstractTransport abstractTransport) {
            abstractTransport.setRestId(transportId);
            if (transport.get(transportId) != null) {
                transport.put(transportId, abstractTransport);
                return transport.get(transportId);
            } else {
                return null;
            }
    }
}
