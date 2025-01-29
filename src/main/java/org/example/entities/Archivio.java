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

    public static ElementoCatalogo searchByISBN(long ISBN) {
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
        Query q = em.createQuery(
                "SELECT p FROM Prestito p WHERE p.utente.numeroDiTessera = :numeroDiTessera AND p.dataRestituzioneEffettiva IS NULL"
        );
        q.setParameter("numeroDiTessera", numeroDiTessera);

        List<Prestito> prestiti = q.getResultList();

        return prestiti;
    }


    public static List<Prestito> searchPrestitiScadutieNonAncoraRestituiti(){
        Query q = em.createQuery("SELECT p FROM Prestito p WHERE  p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL ");

        return q.getResultList();
    };

}
