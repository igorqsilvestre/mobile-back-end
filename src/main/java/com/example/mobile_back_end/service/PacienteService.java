package com.example.mobile_back_end.service;


import com.example.mobile_back_end.interfaces.GenericOperations;
import com.example.mobile_back_end.model.Paciente;
import com.example.mobile_back_end.repository.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional()
public class PacienteService implements GenericOperations<Paciente, Integer> {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public Paciente create(Paciente entity) {
        return pacienteRepository.save(entity);
    }


    @Override
    public Paciente updatePart(Integer id, Paciente entity) {

        Paciente pacienteEncontrado = this.read(id);

        if(pacienteEncontrado != null){
            entity.setId(pacienteEncontrado.getId());
            return pacienteRepository.save(entity);
        }

        return new Paciente();
    }

    public Paciente updateSenha(String senha, Paciente paciente) {

        Paciente pacienteEncontrado = this.read(paciente.getId());

        if(pacienteEncontrado != null){
            pacienteEncontrado.setSenha(senha);
            return pacienteEncontrado;
        }

        return new Paciente();
    }


    @Override
    public Paciente updateAll(Integer id, Paciente entity) {

        Paciente pacienteEncontrado = this.read(id);

        if(pacienteEncontrado != null){
            entity.setId(pacienteEncontrado.getId());
            return pacienteRepository.save(entity);
        }

        return new Paciente();
    }

    @Override
    public void delete(Integer id) {
        pacienteRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Paciente read(Integer id) {
        return pacienteRepository.findById(id)
                .orElseGet(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Paciente> readAll() {
        return pacienteRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Paciente readByCPF(String cpf) {
        return pacienteRepository.findByCpf(cpf)
                .orElse(null);
    }


    public Paciente readByEmail(String email) {
        return pacienteRepository.findByEmail(email).orElse(null);
    }


    public Paciente readByEmailAndSenha(String email, String senha) {
        return pacienteRepository.findByEmailAndSenha(email,senha).orElse(null);
    }
}
