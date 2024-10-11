package com.example.mobile_back_end.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cep", length = 8, nullable = false)
    private String cep;

    @Column(name = "logradouro", nullable = false)
    private String logradouro;

    @Column(name = "bairro", nullable = false)
    private String bairro;

    @Column(name = "cidade",nullable = false)
    private String cidade;

    @Column(name = "estado",nullable = false)
    private String estado;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @JsonIgnoreProperties("endereco") // Evita recursão infinita
    @OneToOne(mappedBy = "endereco")
    private Paciente paciente;

}
