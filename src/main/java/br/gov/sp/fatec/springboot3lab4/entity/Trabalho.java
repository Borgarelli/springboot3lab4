package br.gov.sp.fatec.springboot3lab4.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tra_trabalho")
public class Trabalho {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tra_id")
    private Long tra_id;

    @Column(name = "tra_titulo")
    private String tra_titulo;

    @Column(name = "tra_data_hora_entrega")
    private LocalDateTime tra_entrega;

    @Column(name = "tra_descricao")
    private String desc;

    @Column(name = "tra_grupo")
    private String group;

    @Column(name = "tra_nota")
    private Long note;

    @Column(name = "tra_justificativa")
    private String justify;
}
