package com.example.mobile_back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa{

    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();

    @Column (name="senha", length = 30, nullable = true, unique = false)
    private String senha;

    private String getSenha() {
        return this.senha;
    }



}
