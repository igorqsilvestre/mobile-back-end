package com.example.mobile_back_end.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nomeTratamento", nullable = false)
    private String nomeTratamento;

    @Column (name="imagemTratamento", nullable = false )
    private String imagemTratamento;

    @Column(name = "avaliacaoTratamento", nullable = false)
    private double avaliacaoTratamento;

    @Column(name = "dataHorario", nullable = false)
    private Date dataHorario;

    @Column(name = "preco", nullable = false)
    private double preco;

}
