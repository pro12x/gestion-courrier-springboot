package com.webgram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "correspondant")
//@MappedSuperclass
public class Contact implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String prenom;//E/D
    private String nom;//E/D
    private String type;//E/D
    private String civilite;//E/D
    private String fonction;//E/D
    private String postal;//E/Da
    private String ville;//E/D
    private String adresse;//E/D
    private String email;//E/D
    private String telephone;//E/D
    private String service;//E/D
    private boolean isArchived;//E/D
}
