package com.webgram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@MappedSuperclass
public class Courrier implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 7, nullable = false)
    private String code;//I/O
    @Column(length = 15, nullable = false)
    private String reference;//I/O
    private String objet;//I/O
    private String reponse;//I/O
    private String type;//I/O
    private String nature;//I/O
    private String statut;//I/O
    @Column(length = 5000)
    private String resume;//I/O
    @Column(length = 5000)
    private String comment;//I/O
    private String expediteur;//I/O
    private String destinataire;//I/O
    private String documents;//I/O
    @Column(name = "date_redaction")
    private Date dateRedaction;//I/O
    private boolean isArchived;//I/O
}
