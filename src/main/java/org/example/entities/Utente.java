package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "utenti")
public class Utente {
    @Id
    @GeneratedValue
    @Column(name = "numero_di_tessera")
    private int numeroDiTessera;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String cognome;
    @Column(name = "data_di_nascita",nullable = false)
    private LocalDate dataDiNascita;
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List <Prestito> prestitiPersonali = new ArrayList<>();

    public Utente(String nome, String cognome, LocalDate dataDiNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;

    }

    public Utente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getAnnoDiPubblicazione() {
        return dataDiNascita;
    }

    public void setAnnoDiPubblicazione(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public void setNumeroDiTessera(int numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }

    public List<Prestito> getPrestitiPersonali() {
        return prestitiPersonali;
    }

    public void setPrestitiPersonali(List<Prestito> prestitiPersonali) {
        this.prestitiPersonali = prestitiPersonali;
    }

    @Override
    public String toString() {
        return
                "nome:" + nome +
                ", cognome:" + cognome +
                ", dataDiNascita:" + dataDiNascita +
                ", numeroDiTessera:" + numeroDiTessera
                        ;
    }
}
