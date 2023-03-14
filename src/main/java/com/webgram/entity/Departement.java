package com.webgram.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "departement")
public class Departement implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 7, nullable = false)
    private String code;
    private String libelle;
    private boolean isArchived;

    @OneToMany(mappedBy = "departement")
    @JsonIgnore
    private List<Services> services;
}
