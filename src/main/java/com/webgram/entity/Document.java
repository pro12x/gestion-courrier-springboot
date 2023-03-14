package com.webgram.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Document
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reference;
    private String titre;
    private String chemin;
    private Long taille;
    @Column(name = "date_ajout")
    private String dateAjout;
    private boolean isArchived;
}
