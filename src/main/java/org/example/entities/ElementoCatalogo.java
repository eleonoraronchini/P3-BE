package org.example.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "catalogo_prodotti")
@Inheritance(strategy = InheritanceType.JOINED)
public class ElementoCatalogo {
    @Id
    @GeneratedValue
    private long codiceISBN;
    @Column(nullable = false)
    private String titolo;
    @Column(name = "anno_di_pubblicazione", nullable = false)
    private int annoDiPubblicazione;
    @Column(name = "numero_pagine", nullable = false)
    private int numPagine;
    @ManyToMany(mappedBy = "elementiCatalogo", cascade = CascadeType.ALL)
    private List<Prestito> prestiti;

    public ElementoCatalogo (String titolo, int annoDiPubblicazione, int numPagine){
        this.titolo=titolo;
        this.annoDiPubblicazione=annoDiPubblicazione;
        this.numPagine=numPagine;

    }

    public ElementoCatalogo() {
    }


    public long getCodiceISBN() {
        return codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getNumPagine() {
        return numPagine;
    }


    public int getAnnoDiPubblicazione() {
        return annoDiPubblicazione;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }


    public void setAnnoDiPubblicazione(int annoDiPubblicazione) {
        this.annoDiPubblicazione = annoDiPubblicazione;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setCodiceISBN(long codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return
                "CodiceISBN:" + codiceISBN +
                        ", Titolo: " + titolo +
                        ", Anno di pubblicazione:" + annoDiPubblicazione +
                        ", Numero di pagine:" + numPagine
                ;
    }
}

