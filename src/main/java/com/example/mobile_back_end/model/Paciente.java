package com.example.mobile_back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "paciente")
public class Paciente{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column (name="senha", length = 16, nullable = false )
    private String senha;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;

    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Column(name = "dataNascimento", length = 10, nullable = false)
    private Date dataNascimento;


}
