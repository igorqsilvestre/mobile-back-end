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

        // Busca o paciente no banco de dados
        Paciente pacienteEncontrado = this.read(id);

        if (pacienteEncontrado != null) {
            // Atualiza apenas os campos que foram fornecidos na requisição (que não são nulos)
            if (entity.getEmail() != null) {
                pacienteEncontrado.setEmail(entity.getEmail());
            }
            if (entity.getSenha() != null) {
                pacienteEncontrado.setSenha(entity.getSenha());
            }
            if (entity.getNome() != null) {
                pacienteEncontrado.setNome(entity.getNome());
            }
            if (entity.getCpf() != null) {
                pacienteEncontrado.setCpf(entity.getCpf());
            }
            if (entity.getTelefone() != null) {
                pacienteEncontrado.setTelefone(entity.getTelefone());
            }
            if (entity.getDataNascimento() != null) {
                pacienteEncontrado.setDataNascimento(entity.getDataNascimento());
            }
            if (entity.getEndereco() != null) {
                // Atualiza o endereço apenas se não for nulo. Pode-se tratar isso de maneira mais refinada se necessário.
                pacienteEncontrado.setEndereco(entity.getEndereco());
            }

            // Salva o paciente com as informações atualizadas
            return pacienteRepository.save(pacienteEncontrado);
        }

        // Retorna um objeto vazio ou lança exceção, conforme a necessidade
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


    @Transactional(readOnly = true)
    public Paciente readByEmail(String email) {
        return pacienteRepository.findByEmail(email).orElse(null);
    }


    @Transactional(readOnly = true)
    public Paciente readByEmailAndSenha(String email, String senha) {
        return pacienteRepository.findByEmailAndSenha(email,senha).orElse(null);
    }
}
