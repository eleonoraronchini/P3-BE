package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "riviste")
public class Rivista extends ElementoCatalogo{

    @Enumerated(EnumType.STRING)
    private Periodicità periodicità;

    public Rivista(String titolo, int annoDiPubblicazione, int numPagine, Periodicità periodicità) {
        super(titolo, annoDiPubblicazione, numPagine);
        this.periodicità = periodicità;
    }

    public Rivista() {
    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return
                super.toString() +
                        ", Periodicità: " + periodicità;
    }


}