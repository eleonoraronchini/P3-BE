package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "libri")
public class Libri extends ElementoCatalogo {
    @Column(nullable = false)
    private String autore;
    @Column(nullable = false)
    private String genere;

    public Libri(String titolo, int annoDiPubblicazione, int numPagine, String autore, String genere) {
        super( titolo, annoDiPubblicazione, numPagine);
        this.autore = autore;
        this.genere= genere;
    }

    public Libri() {

    };

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                        ", Autore:" + autore +
                        ", Genere:" + genere
                ;
    }



}





