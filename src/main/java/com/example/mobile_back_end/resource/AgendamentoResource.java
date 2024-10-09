package com.example.mobile_back_end.resource;

import com.example.mobile_back_end.interfaces.GenericOperations;
import com.example.mobile_back_end.model.Agendamento;
import com.example.mobile_back_end.service.AgendamentoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/agendamento")
public class AgendamentoResource implements GenericOperations<Agendamento, Integer> {

    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping("/ping")
    public boolean ping() {
        return true;
    }


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Agendamento create(@Valid @RequestBody Agendamento entity) {
        return agendamentoService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Agendamento read(@PathVariable  Integer id) {
        return agendamentoService.read(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Agendamento> readAll() {
        return agendamentoService.readAll();
    }


    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Agendamento updatePart(@PathVariable("id")  Integer id, @Valid @RequestBody Agendamento entity) {
        return agendamentoService.updatePart(id,entity);
    }


    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Agendamento updateAll(@PathVariable("id") Integer id, @Valid @RequestBody Agendamento entity) {
        return agendamentoService.updateAll(id,entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable("id") Integer id) {
        agendamentoService.delete(id);
    }
}
