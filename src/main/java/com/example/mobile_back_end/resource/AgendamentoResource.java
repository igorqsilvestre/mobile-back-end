package com.example.mobile_back_end.resource;

import ads4.fatesg.pbbellavisage.dto.AgendamentoCreateDto;
import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Agendamento;
import ads4.fatesg.pbbellavisage.model.Especialista;
import ads4.fatesg.pbbellavisage.model.Paciente;
import ads4.fatesg.pbbellavisage.model.Tratamento;
import ads4.fatesg.pbbellavisage.service.AgendamentoService;
import ads4.fatesg.pbbellavisage.service.EspecialistaService;
import ads4.fatesg.pbbellavisage.service.PacienteService;
import ads4.fatesg.pbbellavisage.service.TratamentoService;
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

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private EspecialistaService especialistaService;

    @Autowired
    private TratamentoService tratamentoService;



    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public Agendamento createAgendamentoComDto(@Valid @RequestBody AgendamentoCreateDto entity) {
        Agendamento agendamento = converteDtoEmAgendamento(entity);
        agendamento.setStatus(Agendamento.StatusAgendamento.Aberto);
        return agendamentoService.create(agendamento);
    }

    @Override
    public Agendamento create(@Valid @RequestBody Agendamento entity) {
        return agendamentoService.create(entity);
    }

    @GetMapping(
            value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public Agendamento read(@PathVariable("id")  Integer id) {
        return agendamentoService.read(id);
    }

    @PostMapping(
            value = "/exists/dataHora",
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public boolean existDatahora(@Valid @RequestBody AgendamentoCreateDto entity) {
        return agendamentoService.existsByDataEhoraAndEspecialista(
                entity.getId(), entity.getDataHorario(), entity.getEspecialista());
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @Override
    public List<Agendamento> readAll() {
        return agendamentoService.readAll();
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE},
            value = "/paciente/{paciente}"
    )
    public List<Agendamento> readByPaciente(
            @PathVariable("paciente") Integer id
    ) {
        return agendamentoService.getByPacienteId(id);


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
    public Agendamento atualizaAgendamentoComDto(@PathVariable("id") Integer id, @Valid @RequestBody AgendamentoCreateDto entity) {
        Agendamento agendamento = converteDtoEmAgendamento(entity);
        agendamento.setStatus(Agendamento.StatusAgendamento.valueOf(entity.getStatus()));
        agendamento.setAvaliacao(entity.getAvaliacao());
        return agendamentoService.updateAll(id, agendamento);
    }

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

    private Agendamento converteDtoEmAgendamento(@RequestBody @Valid AgendamentoCreateDto entity) {
        Paciente paciente = pacienteService.read(entity.getPaciente());
        Especialista especialista = especialistaService.read(entity.getEspecialista());
        Tratamento tratamento = tratamentoService.read(entity.getTratamento());

        Agendamento agendamento = new Agendamento();
        agendamento.setDataHorario(entity.getDataHorario());
        agendamento.setValor(entity.getValor());
        agendamento.setPaciente(paciente);
        agendamento.setEspecialista(especialista);
        agendamento.setTratamento(tratamento);
        return agendamento;
    }
}
