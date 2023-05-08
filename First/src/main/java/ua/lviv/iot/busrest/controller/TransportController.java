package ua.lviv.iot.busrest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ua.lviv.iot.busrest.models.AbstractTransport;
import ua.lviv.iot.busrest.service.TransportService;

import java.util.LinkedList;

@RequestMapping("/transport")
@RestController
public final class TransportController {
    private final TransportService transportService = new TransportService();

    @GetMapping
    public LinkedList<AbstractTransport> get() {
        return transportService.getTransport();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AbstractTransport> getById(
            @PathVariable("id") final Integer transportId) {
        return transportService.getTransportById(transportId);
    }

    @PostMapping
    public AbstractTransport
    create(@RequestBody final AbstractTransport abstractTransport) {
        return transportService.createTransport(abstractTransport);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AbstractTransport>
    delete(@PathVariable("id") final Integer transportId) {
        return transportService.deleteTransportById(transportId);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AbstractTransport>
    update(@PathVariable("id") final Integer transportId,
           @RequestBody final AbstractTransport abstractTransport) {
        return transportService.updateTransportById(
                transportId, abstractTransport);
    }

}
