package com.example.mobile_back_end.repository;


import com.example.mobile_back_end.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {

}
