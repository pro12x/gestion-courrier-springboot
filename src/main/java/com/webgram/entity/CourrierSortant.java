package com.webgram.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "correspondance_sortante")
public class CourrierSortant extends Courrier
{
    @Column(name = "date_prevu")
    private String dateEcheante;//O
    @Column(name = "date_reelle")
    private String dateReelle;//O
}
