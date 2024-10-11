package com.example.mobile_back_end.repository;


import com.example.mobile_back_end.model.Endereco;
import com.example.mobile_back_end.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
