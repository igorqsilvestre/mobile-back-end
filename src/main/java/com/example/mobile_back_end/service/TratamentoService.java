package com.example.mobile_back_end.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Tratamento;
import ads4.fatesg.pbbellavisage.repository.TratamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class TratamentoService implements GenericOperations<Tratamento, Integer> {

    @Autowired
    private TratamentoRepository tratamentoRepository;

    @Override
    public Tratamento create(Tratamento entity) {
        return tratamentoRepository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public Tratamento read(Integer id) {
        return tratamentoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Tratamento não encontrado!"));
    }

    @Transactional(readOnly = true)
    public Tratamento readByNome(String nome) {
        return tratamentoRepository.findByNome(nome).orElseThrow(() -> new EntityNotFoundException("Tratamento não encontrado!"));
    }

    @Transactional(readOnly = true)
    @Override
    public List<Tratamento> readAll() {
        return tratamentoRepository.findAll();
    }

    @Override
    public Tratamento updatePart(Integer id, Tratamento entity) {

        Tratamento tratamentoEncontrado = this.read(id);

        if(tratamentoEncontrado != null){
            entity.setId(tratamentoEncontrado.getId());
            return tratamentoRepository.save(entity);
        }

        return new Tratamento();
    }

    @Override
    public Tratamento updateAll(Integer id, Tratamento entity) {

        Tratamento tratamentoEncontrado = this.read(id);

        if(tratamentoEncontrado != null){

            entity.setId(tratamentoEncontrado.getId());
            return tratamentoRepository.save(entity);
        }

        return new Tratamento();
    }

    @Override
    public void delete(Integer id) {
        tratamentoRepository.deleteById(id);
    }


}
