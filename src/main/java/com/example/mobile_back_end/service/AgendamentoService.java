package com.example.mobile_back_end.service;


import com.example.mobile_back_end.interfaces.GenericOperations;
import com.example.mobile_back_end.model.Agendamento;
import com.example.mobile_back_end.repository.AgendamentoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class AgendamentoService implements GenericOperations<Agendamento, Integer> {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public Agendamento create(Agendamento entity) {
        return agendamentoRepository.save(entity);
    }


    @Override
    public Agendamento updatePart(Integer id, Agendamento entity) {

        Agendamento agendamentoEncontrado = this.read(id);

        if(agendamentoEncontrado != null){
            entity.setId(agendamentoEncontrado.getId());
            return agendamentoRepository.save(entity);
        }

        return new Agendamento();
    }


    @Override
    public Agendamento updateAll(Integer id, Agendamento entity) {

        Agendamento agendamentoEncontrado = this.read(id);

        if(agendamentoEncontrado != null){
            entity.setId(agendamentoEncontrado.getId());
            return agendamentoRepository.save(entity);
        }

        return new Agendamento();
    }

    @Override
    public void delete(Integer id) {
        agendamentoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Agendamento read(Integer id) {
        return agendamentoRepository.findById(id)
                .orElseGet(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Agendamento> readAll() {
        return agendamentoRepository.findAll();
    }

}
