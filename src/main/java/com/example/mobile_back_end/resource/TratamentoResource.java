package com.example.mobile_back_end.resource;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Tratamento;
import ads4.fatesg.pbbellavisage.service.TratamentoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "api/v1/tratamento")
public class TratamentoResource implements GenericOperations<Tratamento, Integer> {

    @Autowired
    private TratamentoService tratamentoService;


    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Tratamento create(@Valid @RequestBody Tratamento entity) {
        return tratamentoService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Tratamento read(@PathVariable  Integer id) {
        return tratamentoService.read(id);
    }

    @GetMapping(
            value = "/nome/{nome}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Tratamento readByRegistro(@PathVariable String nome) {
        return tratamentoService.readByNome(nome);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Tratamento> readAll() {
        return tratamentoService.readAll();
    }

    @PatchMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Tratamento updatePart(@PathVariable  Integer id, @Valid @RequestBody Tratamento entity) {
        return tratamentoService.updatePart(id,entity);
    }

    @PutMapping(
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Tratamento updateAll(@PathVariable Integer id, @Valid @RequestBody Tratamento entity) {
        return tratamentoService.updateAll(id,entity);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    @Override
    public void delete(@PathVariable Integer id) {
        tratamentoService.delete(id);
    }
}
