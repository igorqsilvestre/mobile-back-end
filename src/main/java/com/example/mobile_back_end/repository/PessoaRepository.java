package com.example.mobile_back_end.repository;

import ads4.fatesg.pbbellavisage.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
}
