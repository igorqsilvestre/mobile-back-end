package com.example.mobile_back_end.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tratamento")
public class Tratamento extends BaseModel{

    @Column(name = "nome", nullable = false, unique = true)
    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @Column(name = "valor",     nullable = false)
    private BigDecimal valor;

    @Lob
    @Column(name = "descricao",nullable = false)
    private String descricao;

    @Lob
    @Column(name = "imagem")
    private String imagem;

    @JsonIgnore
    @OneToMany(mappedBy = "tratamento", fetch = FetchType.LAZY)
    private List<Agendamento> agendamentos = new ArrayList<>();
}
