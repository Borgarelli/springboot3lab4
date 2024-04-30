package br.gov.sp.fatec.springboot3lab4.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "alu_aluno")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alu_id")
    private Long alu_id;

    @Column(name = "alu_nome_completo")
    private String alu_nome_completo;

    @Column(name = "alu_email_institucional")
    private String alu_email_institucional;

    @Column(name = "alu_data_matricula")
    private LocalDate alu_data_matricula;

    @Column(name = "alu_indice")
    private Float alu_indice;

}
