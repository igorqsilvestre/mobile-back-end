package com.example.mobile_back_end.service;

import ads4.fatesg.pbbellavisage.interfaces.GenericOperations;
import ads4.fatesg.pbbellavisage.model.Paciente;
import ads4.fatesg.pbbellavisage.repository.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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


    @Override
    public Paciente updatePart(Integer id, Paciente entity) {

        Paciente pacienteEncontrado = this.read(id);

        if(pacienteEncontrado != null){

            entity.getEndereco().setId(pacienteEncontrado.getEndereco().getId());
            entity.setId(pacienteEncontrado.getId());
            return pacienteRepository.save(entity);
        }

        return new Paciente();
    }

    @Override
    public Paciente updateAll(Integer id, Paciente entity) {

        Paciente pacienteEncontrado = this.read(id);

        if(pacienteEncontrado != null){
            entity.getEndereco().setId(pacienteEncontrado.getEndereco().getId());
            entity.setId(pacienteEncontrado.getId());
            return pacienteRepository.save(entity);
        }

        return new Paciente();
    }

    @Override
    public void delete(Integer id) {
        pacienteRepository.deleteById(id);
    }


    public Paciente readByEmail(String email) {
        Optional<Paciente> optPaciente = pacienteRepository.findByEmail(email);

        if(!optPaciente.isPresent()) {
            return null;
        }

        Paciente paciente = optPaciente.get();

        //paciente.setSenha(null);
        //perigo: o hibernate fazer update no banco automaticamente

        return paciente;
    }

    public Paciente readByEmailAndSenha(String email, String senha) {
        Optional<Paciente> optPaciente = pacienteRepository.findByEmailAndSenha(email,senha);

        if(!optPaciente.isPresent()){
            return null;
        }
        Paciente paciente = optPaciente.get();
        return paciente;
    }
}
