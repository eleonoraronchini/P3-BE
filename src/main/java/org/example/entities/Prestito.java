package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "prestiti")
public class Prestito {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne (cascade = CascadeType.ALL)
    private Utente utente;
    @ManyToMany
    @JoinTable (
            name = "elementi_presi_in_prestito",
            joinColumns = @JoinColumn(name = "prestito_id"),
            inverseJoinColumns = @JoinColumn(name = "utente_id")
    )
    private List<ElementoCatalogo> elementiCatalogo;
    @Column(name = "data_inizio_prestito", nullable = false)
    private LocalDate dataInizioPrestito;
    @Column(name = "data_restituzione_prevista", nullable = false)
    private LocalDate dataRestituzionePrevista;
    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public Prestito(Utente utente, List<ElementoCatalogo> elementiCatalogo, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.utente = utente;
        this.elementiCatalogo = elementiCatalogo;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Prestito() {
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public List<ElementoCatalogo> getElementiCatalogo() {
        return elementiCatalogo;
    }

    public void setElementiCatalogo(List<ElementoCatalogo> elementiCatalogo) {
        this.elementiCatalogo = elementiCatalogo;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "id" + id +
                ", utente:" + utente +
                ", elementiPrestati:" + elementiCatalogo +
                ", dataInizioPrestito:" + dataInizioPrestito +
                ", dataRestituzionePrevista:" + dataRestituzionePrevista +
                ", getDataRestituzioneEffettiva:" + dataRestituzioneEffettiva
                ;
    }
}
