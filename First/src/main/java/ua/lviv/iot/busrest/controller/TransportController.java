package ua.lviv.iot.busrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @Autowired
    private TransportService transportService;

    @GetMapping
    public LinkedList<AbstractTransport> get() {
        return transportService.getTransport();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AbstractTransport> getById(
            @PathVariable("id") final Integer transportId) {
        if (transportService.getTransportById(transportId) != null) {
            return new ResponseEntity<>(
                    transportService.getTransportById(transportId), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public AbstractTransport
    create(@RequestBody final AbstractTransport abstractTransport) {
        return transportService.createTransport(abstractTransport);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AbstractTransport>
    delete(@PathVariable("id") final Integer transportId) {
        return transportService.deleteTransportById(transportId) == null
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).build()
                : ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AbstractTransport>
    update(@PathVariable("id") final Integer transportId,
           @RequestBody final AbstractTransport abstractTransport) {
        if (transportService.updateTransportById(transportId,
                abstractTransport) != null) {
            return new ResponseEntity<>(
                    transportService.getTransportById(transportId), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
