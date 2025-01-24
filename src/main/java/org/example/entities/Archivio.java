package org.example.entities;

import net.bytebuddy.asm.Advice;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;

import java.util.List;


public class Archivio {
    public static EntityManager em;

    public Archivio(EntityManager em) {
        Archivio.em = em;
    }


    public static void save_elementoCatalogo(ElementoCatalogo e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public static List<ElementoCatalogo> searchByISBN(int ISBN){
        Query q = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.codiceISBN = :ISBN");
        q.setParameter("ISBN", ISBN);
        return q.getResultList();
    };
    public static List<ElementoCatalogo> searchByAnnoDiPubblicazione (LocalDate anno){
        Query q = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoDiPubblicazione = :anno");
        q.setParameter("anno", anno);
        return q.getResultList();
    };
    public static List<Libri> searchByAuthor (String autore){
        Query q = em.createQuery("SELECT l FROM Libri l WHERE l.autore = :autore");
        q.setParameter("autore",autore);
        return q.getResultList();
    };
    public static List<ElementoCatalogo> searchByTitle (String titolo){
        Query q = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.titolo = :titolo");
        q.setParameter("titolo", titolo);
        return q.getResultList();

    };
    public static List <ElementoCatalogo> searchElementsInPrestitoByNumeroTesseraUtente (int numeroTessera, LocalDate data){
        Query q = em.createQuery("SELECT p FROM Prestito p  WHERE p.utente = :numeroTessera AND data BETWEEN p.dataInizioPrestito AND p.dataRestituzioneEffettiva");
        q.setParameter("numero_tessera", numeroTessera);
        q.setParameter("data",data);
        return q.getResultList();

    };
    LocalDate today = LocalDate.now();
    public static List<Prestito> searchPrestitiScadutieNonAncoraRestituiti(LocalDate today ){
        Query q = em.createQuery("SELECT p FROM Prestito p WHERE  p.dataRestituzionePrevista < :today AND p.dataRestituzioneEffettiva IS NULL ");
        q.setParameter("today", today);
        return q.getResultList();
    };

}
