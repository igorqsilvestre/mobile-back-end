package com.example.mobile_back_end.repository;


import com.example.mobile_back_end.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByCpf(String cpf);
    Optional<Paciente> findByEmail(String email);

    Optional<Paciente> findByEmailAndSenha(String email,String senha);

}
