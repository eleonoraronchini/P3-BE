package org.example.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.time.LocalDate;

import java.util.Date;
import java.util.List;


public class Archivio {
    private static EntityManagerFactory emf;
    public static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("progetto3");
        em = emf.createEntityManager();
    }


    public static void save_elementoCatalogo(ElementoCatalogo e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }

    public static ElementoCatalogo searchByISBN(int ISBN){
        Query q = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.codiceISBN = :ISBN");
        q.setParameter("ISBN", ISBN);
        return (ElementoCatalogo) q.getSingleResult();
    };
    public static List<ElementoCatalogo> searchByAnnoDiPubblicazione (int anno){
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
    public static List<Prestito> searchElementsInPrestitoByNumeroTesseraUtente(int numeroDiTessera) {
        LocalDate today = LocalDate.now();
        Query q = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.utente.numeroDiTessera = :numeroDiTessera AND p.dataRestituzionePrevista > :today AND p.dataRestituzioneEffettiva IS NULL"
        );
        q.setParameter("numeroDiTessera", numeroDiTessera);
        q.setParameter("today", today);

        return q.getResultList();
    }

    LocalDate today = LocalDate.now();
    public static List<Prestito> searchPrestitiScadutieNonAncoraRestituiti(LocalDate today ){
        Query q = em.createQuery("SELECT p FROM Prestito p WHERE  p.dataRestituzionePrevista < :today AND p.dataRestituzioneEffettiva IS NULL ");
        q.setParameter("today", today);
        return q.getResultList();
    };

}
