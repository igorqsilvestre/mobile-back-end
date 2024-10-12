package com.example.mobile_back_end.repository;


import com.example.mobile_back_end.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

    List<Agendamento> findByPacienteId(Integer pacienteId);

    // Método para encontrar agendamento por paciente e id do agendamento
    Optional<Agendamento> findByIdAndPacienteId(Integer agendamentoId, Integer pacienteId);

}
