package com.webgram.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "correspondance_entrante")
public class CourrierEntrant extends Courrier
{
    private String priorite;//I
    @Column(name = "date_reception")
    private Date dateReception;//I
    @Column(name = "date_echeante")
    private Date dateEcheante;//I
}