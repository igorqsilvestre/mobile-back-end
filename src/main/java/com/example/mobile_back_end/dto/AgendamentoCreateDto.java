package com.example.mobile_back_end.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;


@Setter
@Getter
public class AgendamentoCreateDto {
    private Integer id;
    @NotNull
    private Date dataHorario;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private Integer paciente;
    @NotNull
    private Integer especialista;
    @NotNull
    private Integer tratamento;
    private String status;
    private Integer avaliacao;
}
